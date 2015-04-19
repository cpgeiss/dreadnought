package com.fixmyfolks.app.resources;

import java.net.URI;
import java.util.List;

import io.dropwizard.jersey.sessions.Session;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.app.AppConfiguration;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;
import com.fixmyfolks.justgiving.JustGiving;
import com.fixmyfolks.justgiving.model.Category;
import com.fixmyfolks.justgiving.model.SearchResult;
import com.fixmyfolks.venmo.Venmo;

@Path("/giving")
@Produces(MediaType.APPLICATION_JSON)
public class GivingResource extends BaseResource {
    private final JustGiving giving;
    private final Venmo venmo;
    private final AppConfiguration config;

    public GivingResource(FixFolkData data, JustGiving giving, Venmo venmo, AppConfiguration config) {
        super(data);
        this.giving = giving;
        this.venmo = venmo;
        this.config = config;
    }

    @POST
    @Path("/charities")
    public List<SearchResult> charities(@FormParam("query") String query, @Session HttpSession session) {
        return giving.charitySearch(config.getGivingAppId(), query).getCharitySearchResults();
    }

    @GET
    @Path("/form/{problemId}/{charityId}")
    @Produces(MediaType.TEXT_HTML)
    public GivingCharitiesForm form(@PathParam("problemId") String problemId, @PathParam("charityId") String charityId, @Session HttpSession session) {
        Problem problem = getData().getProblemById(problemId);
        return new GivingCharitiesForm(getSessionAccount(session), getData().getJustGivingDonationFormUrl(charityId, problem.getPrice(), problemId));
    }

    @GET
    @Path("/charities")
    @Produces(MediaType.TEXT_HTML)
    public GivingCharitiesView assignCharity(@QueryParam("problemId") String problemId, @Session HttpSession session) {
        return new GivingCharitiesView(getSessionAccount(session), problemId);
    }

    @GET
    @Path("/categories")
    public List<Category> categories(@Session HttpSession session) {
        return giving.categories(config.getGivingAppId());
    }

    @GET
    @Path("/donate/{problemId}/{charityId}")
    public Response donate(@PathParam("problemId") final String problemId, @PathParam("charityId") final String charityId) {
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                Problem problem = getData().getProblemById(problemId);
                Account fixer = getData().getAccountById(problem.getFixer().toString());
                SearchResult charity = giving.charity(config.getGivingAppId(), charityId);
                venmo.makePayment(fixer.getToken().getAccessToken(), fixer.getToken().getUser().getId(), problem.getPrice().toString(), "Fixed - " + problem.getDescription());
                getData().flagDonationOnProblem(problemId, charity);
            }
        });
        t.start();
        return Response.seeOther(URI.create("/")).build();
    }
}
