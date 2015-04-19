package com.fixmyfolks.app.resources;

public class VenmoLoginView extends SessionView {

	private String type;
	private String venmoClientId;
	
	protected VenmoLoginView(String type, String venmoClientId) {
		super(null, "venmo_login.ftl");
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