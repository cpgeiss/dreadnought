package com.fixmyfolks.app;

import io.dropwizard.Configuration;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AppConfiguration extends Configuration {
    public static final String DEFAULT_VENMO_ENDPOINT = "https://api.venmo.com";
    public static final String DEFAULT_GIVING_ENDPOINT = "https://api.justgiving.com";
    public static final String DEFAULT_PROBLEM_SUBJECT = "New Problem In The {category} Category";
    public static final String DEFAULT_PROBLEM_BODY = "email/email.html";

	@NotEmpty
	private String version;
	
	@NotEmpty
	private String db;
	
	@NotEmpty
	private String venmoClientId;
	
	@NotEmpty
	private String venmoClientSecret;

    private String venmoClientEndpoint = DEFAULT_VENMO_ENDPOINT;

    private String givingEndpoint = DEFAULT_GIVING_ENDPOINT;

    private String sendGridBody = DEFAULT_PROBLEM_BODY;

    private String sendGridFrom = "noreply@fixmyfolks.com";
	
	@NotEmpty
	private String sendGridUsername;
	
	@NotEmpty
	private String sendGridPassword;

    @NotEmpty
    private String givingAppId;

    @NotEmpty
    private String baseJustGivingFormUrl;

    @NotEmpty
    private String justGivingRedirectUrl;

    private String sendGridSubject = DEFAULT_PROBLEM_SUBJECT;
	
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

	@JsonProperty
	public String getSendGridUsername() {
		return sendGridUsername;
	}

	@JsonProperty
	public String getSendGridPassword() {
		return sendGridPassword;
	}

    @JsonProperty
    public String getVenmoClientEndpoint() {
        return venmoClientEndpoint;
    }

    @JsonProperty
    public String getGivingEndpoint() {
        return givingEndpoint;
    }

    @JsonProperty
    public String getGivingAppId() {
        return givingAppId;
    }

    @JsonProperty
    public String getBaseJustGivingFormUrl() {
        return baseJustGivingFormUrl;
    }

    @JsonProperty
    public String getJustGivingRedirectUrl() {
        return justGivingRedirectUrl;
    }

    @JsonProperty
    public String getSendGridSubject() {
        return sendGridSubject;
    }

    @JsonProperty
    public String getSendGridBody() {
        return sendGridBody;
    }

    @JsonProperty
    public String getSendGridFrom() {
        return sendGridFrom;
    }
	
}
