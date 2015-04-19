package com.fixmyfolks.app.resources;

import io.dropwizard.jersey.sessions.Session;

import java.net.URI;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.fixmyfolks.app.AppConfiguration;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;
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
	@Path("/logout")
	public Response logout(@Session HttpSession session) {
		session.removeAttribute("id");
		return Response.seeOther(URI.create("/")).build();
	}
	
	@GET
	@Path("/authorize")
	public Response authorize(@QueryParam("code") String code, @Session HttpSession session) {
		OAuthToken token = venmo.authenticate(
				config.getVenmoClientId(),
				config.getVenmoClientSecret(),
				code);
		String type = session.getAttribute("type").toString();
		Account account = getData().getAccountByVenmoId(token.getUser().getId());
		if (account == null) {
			account = new Account();
		}
		account.setFixer(type.equalsIgnoreCase("fixer"));
		if (account.isFixer()) {
			List<String> interests = Arrays.asList(
					"Phone-iPhone",
					"Phone-Other",
					"Tablet-iPad",
					"Tablet-Other",
					"Mac-Email",
					"Mac-Internet",
					"Mac-Office",
					"Mac-Music",
					"Mac-Photos",
					"Mac-Printer",
					"Mac-Other",
					"Windows-Email",
					"Windows-Internet",
					"Windows-Office",
					"Windows-Music",
					"Windows-Photos",
					"Windows-Printer",
					"Windows-Other",
					"Television-DVR",
					"Television-Movies",
					"Television-Other");
			account.setInterests(interests);
		}
		account.setToken(token);
		getData().save(account);
		session.setAttribute("id", account.getId().toString());
		String uri = account.isFixer() ? "/problems/current" : "/problems/new";
		return Response.seeOther(URI.create(uri)).build();
	}
	
}
