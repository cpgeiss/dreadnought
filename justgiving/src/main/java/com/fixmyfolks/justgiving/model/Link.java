package com.fixmyfolks.justgiving.model;

public class Link {
    private String rel;
    private String uri;
    private String type;

    public String getRel() {
        return rel;
    }

    public String getUri() {
        return uri;
    }

    public String getType() {
        return type;
    }

    public void setRel(String rel) {
        this.rel = rel;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setType(String type) {
        this.type = type;
    }
}
