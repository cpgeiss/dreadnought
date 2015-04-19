package com.fixmyfolks.data.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;

import com.fixmyfolks.justgiving.model.SearchResult;

@Entity("fixers")
public class Fixer {
    @Id
    private ObjectId id;
    private String email;
    private List<String> tags;
    @Embedded
    private OAuthToken token;
    @Embedded
    private SearchResult charity;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public OAuthToken getToken() {
        return token;
    }

    public void setToken(OAuthToken token) {
        this.token = token;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public SearchResult getCharity() {
        return charity;
    }

    public void setCharity(SearchResult charity) {
        this.charity = charity;
    }
}
