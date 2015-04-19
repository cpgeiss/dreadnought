package com.fixmyfolks.app.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.app.AppConfiguration;
import com.fixmyfolks.venmo.Venmo;
import com.fixmyfolks.venmo.model.OAuthToken;

@Path("/accounts")
@Produces(MediaType.TEXT_HTML)
public class AccountResource extends BaseResource {
    private Venmo venmo;
    private AppConfiguration config;

	public AccountResource(FixFolkData data, Venmo venmo, AppConfiguration config) {
		super(data);
    this.venmo = venmo;
    this.config = config;
	}
	
	@GET
	@Path("/authorize")
	public Response authorize(@QueryParam("code") String code) {
      OAuthToken token = venmo.authenticate(
          config.getVenmoClientId(),
          config.getVenmoClientSecret(),
          code);
		return null;
	}
//	
//	@GET
//	public Response redirectAccount() {
//		return Response.seeOther(URI.create("/accounts/fixer")).build();
//	}

}
