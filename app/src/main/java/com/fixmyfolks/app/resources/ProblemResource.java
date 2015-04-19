package com.fixmyfolks.app.resources;

import io.dropwizard.jersey.sessions.Session;

import javax.servlet.http.HttpSession;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.model.Account;

@Path("/problems")
public class ProblemResource extends BaseResource {

	public ProblemResource(FixFolkData data) {
		super(data);
	}
	
	@GET
	public ProblemIndexView getProblemIndex(@Session HttpSession session) {
		Account account = getSessionAccount(session);
		return new ProblemIndexView();
	}
}
