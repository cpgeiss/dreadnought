package com.fixmyfolks.data.model;

import java.util.List;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Embedded;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Index;

import com.fixmyfolks.venmo.model.OAuthToken;

@Entity("accounts")
@Index("token.user.id")
public class Account {
    @Id
    private ObjectId id;
    private List<String> interests;
    @Embedded
    private OAuthToken token;
    private boolean fixer;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<String> getInterests() {
        return interests;
    }

    public void setInterests(List<String> interests) {
        this.interests = interests;
    }

    public OAuthToken getToken() {
        return token;
    }

    public void setToken(OAuthToken token) {
        this.token = token;
    }

	public boolean isFixer() {
		return fixer;
	}

	public void setFixer(boolean fixer) {
		this.fixer = fixer;
	}

}
