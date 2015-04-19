package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

public class IndexView extends View {

	private String venmoClientId;
	
	public IndexView(String venmoClientId) {
		super("index.ftl");
		this.venmoClientId = venmoClientId;
	}

	public String getVenmoClientId() {
		return venmoClientId;
	}

}