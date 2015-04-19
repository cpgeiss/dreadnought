package com.fixmyfolks.app.resources;

import io.dropwizard.jersey.sessions.Session;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.fixmyfolks.data.FixFolkData;

@Path("/")
@Produces(MediaType.TEXT_HTML)
public class IndexResource extends BaseResource {
	
	private String venmoClientId;
	private String venmoClientSecret;
	
	public IndexResource(FixFolkData data, String venmoClientId, String venmoClientSecret) {
		super(data);
		this.venmoClientId = venmoClientId;
		this.venmoClientSecret = venmoClientSecret;
	}

	@GET
	public IndexView getIndex() {
		return new IndexView();
	}
	
	@GET
	@Path("/select")
	public VenmoLoginView selectType(@QueryParam("type") String type, @Session HttpSession session) {
		session.setAttribute("type", type);
		return new VenmoLoginView(type, venmoClientId);
//		return Response.seeOther(URI.create(return Response.seeOther(location))).build();
	}
	
}
