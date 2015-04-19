package com.fixmyfolks.app.resources;

import java.net.URI;
import java.util.List;

import io.dropwizard.jersey.sessions.Session;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.app.AppConfiguration;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.justgiving.JustGiving;
import com.fixmyfolks.justgiving.model.Category;
import com.fixmyfolks.justgiving.model.Charity;

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
    public List<Charity> charities(@FormParam("query") String query, @Session HttpSession session) {
        return giving.charitySearch(config.getGivingAppId(), query);
    }

    @GET
    @Path("/categories")
    public List<Category> categories(@Session HttpSession session) {
        return giving.categories(config.getGivingAppId());
    }

    @GET
    @Path("/donate/{problemId}")
    public Response donate(String problemId) {
        getData().flagDonationOnProblem(problemId);
        return Response.seeOther(URI.create("/accounts/show")).build();
    }
}
