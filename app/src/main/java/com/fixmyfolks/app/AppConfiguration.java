package com.fixmyfolks.app;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfiguration extends Configuration {

	@NotEmpty
	private String version;
	
	@NotEmpty
	private String db;
	
	@NotEmpty
	private String venmoClientId;
	
	@NotEmpty
	private String venmoClientSecret;
	
	@JsonProperty
	public String getVersion() {
		return version;
	}
	
	@JsonProperty
	public String getDb() {
		return db;
	}
	
	@JsonProperty
	public String getVenmoClientId() {
		return venmoClientId;
	}
	
	@JsonProperty
	public String getVenmoClientSecret() {
		return venmoClientSecret;
	}
	
}