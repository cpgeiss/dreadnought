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
import com.fixmyfolks.data.model.Problem;
import com.fixmyfolks.justgiving.JustGiving;
import com.fixmyfolks.justgiving.model.Category;
import com.fixmyfolks.justgiving.model.SearchResult;

@Path("/giving")
@Produces(MediaType.APPLICATION_JSON)
public class GivingResource extends BaseResource {
    private final JustGiving giving;
    private final AppConfiguration config;

    public GivingResource(FixFolkData data, JustGiving giving, AppConfiguration config) {
        super(data);
        this.giving = giving;
        this.config = config;
    }

    @POST
    @Path("/charities")
    public List<SearchResult> charities(@FormParam("query") String query, @Session HttpSession session) {
        return giving.charitySearch(config.getGivingAppId(), query).getCharitySearchResults();
    }

    @GET
    @Path("/form")
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
    public Response donate(@PathParam("problemId") String problemId, @PathParam("charityId") String charityId) {
        SearchResult charity = giving.charity(config.getGivingAppId(), charityId);
        getData().flagDonationOnProblem(problemId, charity);
        return Response.seeOther(URI.create("/")).build();
    }
}
