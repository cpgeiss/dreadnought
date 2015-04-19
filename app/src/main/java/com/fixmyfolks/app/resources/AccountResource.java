package com.fixmyfolks.app.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.data.FixFolkData;

@Path("/accounts")
@Produces(MediaType.TEXT_HTML)
public class AccountResource extends BaseResource {

	public AccountResource(FixFolkData data) {
		super(data);
	}
	
	@GET
	@Path("/authorize")
	public Response authorize(@QueryParam("code") String code) {
		return null;
	}
//	
//	@GET
//	public Response redirectAccount() {
//		return Response.seeOther(URI.create("/accounts/fixer")).build();
//	}

}