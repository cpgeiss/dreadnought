package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

public class VenmoLoginView extends View {

	private String type;
	private String venmoClientId;
	
	protected VenmoLoginView(String type, String venmoClientId) {
		super("venmo_login.ftl");
		this.type = type;
		this.venmoClientId = venmoClientId;
	}

	public String getType() {
		return type;
	}
	
	public String getVenmoClientId() {
		return venmoClientId;
	}

}