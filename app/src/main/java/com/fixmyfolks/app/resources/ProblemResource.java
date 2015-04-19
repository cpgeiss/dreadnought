package com.fixmyfolks.app.resources;

import io.dropwizard.jersey.sessions.Session;
import io.dropwizard.views.View;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URI;

import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.app.AppConfiguration;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;
import com.sendgrid.SendGrid;

@Path("/problems")
public class ProblemResource extends BaseResource {
    private final AppConfiguration config;

	public ProblemResource(FixFolkData data, AppConfiguration config) {
		super(data);
      this.config = config;
	}
	
	@GET
	public View index(@Session HttpSession session) {
		Account account = getSessionAccount(session);
		View view = null;
		if (account.isFixer()) {
			view = new ProblemFixerIndexView(account, getData().getProblemsForFixer(account).asList());
		} else {
			view = new ProblemFolkIndexView(account, getData().getProblemsForFolk(account).asList()); 
		}
		return view;
	}
	
	@GET
	@Path("/current")
	public ProblemFixerCurrentView currentProblems(@Session HttpSession session) {
		Account account = getSessionAccount(session);
		return new ProblemFixerCurrentView(account, getData().getAvailableProblemsForFixer(account).asList());
	}
	
	@GET
	@Path("/new")
	public ProblemFormView newProblem(@Session HttpSession session) {
		return new ProblemFormView(getSessionAccount(session));
	}
	
	@POST
	public FolkScreenShareView createProblem(@FormParam("tag") String tag, @FormParam("description") String description, @FormParam("amount") String amount, @Session HttpSession session) {
		Account account = getSessionAccount(session);
		final Problem problem = new Problem();
		problem.setFolk(account.getId());
		problem.setTag(tag);
		problem.setDescription(description);
		problem.setPrice(Double.parseDouble(amount));
		getData().save(problem);
		Thread t = new Thread(new Runnable() {
			public void run() {
          InputStream input = getClass().getClassLoader().getResourceAsStream(config.getSendGridBody());
          String body = getStringFromInput(input);
          SendGrid gridMail = new SendGrid(config.getSendGridUsername(), config.getSendGridPassword());
          SendGrid.Email email = new SendGrid.Email();
          email.setFrom(config.getSendGridFrom());
          email.setFromName("Fix My Folks");
          email.setSubject(config.getSendGridSubject().replace("{category}", problem.getTag()));
          String description = problem.getDescription();
          if (description.length() > 100) {
              description = description.substring(0, 100) + "...";
          }
          email.setHtml(body
              .replace("{category}", problem.getTag())
              .replace("{amount}", String.format("%.2f", problem.getPrice()))
              .replace("{description}", description)
              .replace("{fixLink}", config.getAppDomain() + "/problems/start?problemId=" + problem.getId().toString())
              .replace("{buttonImage}", config.getAppDomain() + "/problems/image/" + problem.getId().toString()));
          for (Account fixer : getData().getFixersInterestedInTag(problem.getTag())) {
              email.addTo(fixer.getToken().getUser().getEmail());
              email.addToName(fixer.getToken().getUser().getFirstName());
          }
          try {
              gridMail.send(email);
          } catch (Exception e) {
              // Swalloooooow
          }
			}
		});
		t.start();
		return new FolkScreenShareView(account, problem);
	}
    private String getStringFromInput(InputStream input) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        try {
            int read = input.read(buffer);
            while (read > 0) {
                bos.write(buffer, 0, read);
                read = input.read(buffer);
            }
            return new String(bos.toByteArray(), "UTF-8");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
	
	@GET
	@Path("/start")
	public ScreenShareView startScreenShare(@QueryParam("id") String id, @Session HttpSession session) {
		Problem problem = getData().getProblemById(id);
		Account account = getSessionAccount(session);
		problem.setFixer(account.getId());
		getData().save(problem);
		return new ScreenShareView(account, problem);
	}
	
	@GET
	@Path("/delete")
	public Response deleteProblem(@QueryParam("id") String id, @Session HttpSession session) {
		getData().delete(getData().getProblemById(id));
		return Response.seeOther(URI.create("/problems")).build();
	}
	
	@GET
	@Path("/fixed")
	public Response problemFixed(@QueryParam("id") String id, @Session HttpSession session) {
		Problem problem = getData().getProblemById(id);
		problem.setFixed(true);
		getData().save(problem);
		return Response.seeOther(URI.create("/problems")).build();
	}
	
	@GET
	@Path("/status")
	@Produces(MediaType.APPLICATION_JSON)
	public Problem problemStatus(@QueryParam("id") String id) {
		return getData().getProblemById(id);
	}
	
}
