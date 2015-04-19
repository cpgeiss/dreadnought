package com.fixmyfolks.app.resources;

import io.dropwizard.jersey.sessions.Session;
import io.dropwizard.views.View;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

@Path("/problems")
public class ProblemResource extends BaseResource {

	public ProblemResource(FixFolkData data) {
		super(data);
	}
	
	@GET
	public View index(@Session HttpSession session) {
		Account account = getSessionAccount(session);
		List<Problem> problems = null;
		if (account.isFixer()) {
			problems = getData().getProblemsForFixer(account).asList();
		} else {
			problems = getData().getProblemsForFolk(account).asList();
		}
		return new ProblemFolkIndexView(problems);
	}
	
	@GET
	@Path("/new")
	public ProblemFormView newProblem(@Session HttpSession session) {
		getSessionAccount(session);
		return new ProblemFormView();
	}
	
	@POST
	public Response createProblem(@FormParam("tag") String tag, @FormParam("description") String description, @FormParam("amount") String amount, @Session HttpSession session) {
		Account account = getSessionAccount(session);
		Problem problem = new Problem();
		problem.setFolk(account.getId());
		problem.setTag(tag);
		problem.setDescription(description);
		problem.setPrice(Double.parseDouble(amount));
		getData().save(problem);
		return Response.seeOther(URI.create("/problems")).build();
	}
}
