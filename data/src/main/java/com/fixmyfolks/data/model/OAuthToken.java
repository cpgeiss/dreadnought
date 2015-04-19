package com.fixmyfolks.data.model;

import org.mongodb.morphia.annotations.Embedded;

@Embedded
public class OAuthToken {
    private String accessToken;
    private String refreshToken;
    private String type;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
