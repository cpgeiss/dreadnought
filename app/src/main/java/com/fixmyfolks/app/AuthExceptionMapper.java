package com.fixmyfolks.app;

import java.net.URI;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

public class AuthExceptionMapper implements ExceptionMapper<AuthException> {

	@Override
	public Response toResponse(AuthException exception) {
		return Response.seeOther(URI.create("/")).build();
	}

}