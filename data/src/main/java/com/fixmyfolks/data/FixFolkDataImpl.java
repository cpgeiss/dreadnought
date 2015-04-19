package com.fixmyfolks.data;

import java.net.URLEncoder;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;
import com.fixmyfolks.justgiving.model.SearchResult;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class FixFolkDataImpl implements FixFolkData {
    private Datastore datastore;
    private String baseJustGivingBase;
    private String redirectUrl;

    public FixFolkDataImpl(MongoClient mongoClient, String dbName) {
        datastore = createMorphia().createDatastore(mongoClient, dbName);
        try {
        	datastore.ensureIndexes();
        } catch (MongoException e) {
        	// Ignore, running on MongoLab
        }
    }

    public FixFolkDataImpl setJustGivingBase(String baseJustGivingBase) {
        this.baseJustGivingBase = baseJustGivingBase;
        return this;
    }

    public FixFolkDataImpl setRedirectUrl(String redirectUrl) {
        this.redirectUrl = redirectUrl;
        return this;
    }

    private Morphia createMorphia() {
        Morphia morphia = new Morphia();
        morphia.map(
            Account.class,
            Problem.class
        );
        return morphia;
    }
    
    @Override
    public Query<Problem> getAllProblems() {
        return datastore.find(Problem.class);
    }

    @Override
    public Query<Account> getAllAccounts() {
        return datastore.find(Account.class);
    }

    @Override
    public Account getAccountById(String id) {
        return datastore.get(Account.class, new ObjectId(id));
    }

    @Override
    public Problem getProblemById(String id) {
        return datastore.get(Problem.class, new ObjectId(id));
    }
    
    @Override
	public Query<Problem> getProblemsForFolk(Account account) {
		return datastore.find(Problem.class).field("folk").equal(account.getId()).order("-id");
	}

	@Override
	public Query<Problem> getProblemsForFixer(Account account) {
		return datastore.find(Problem.class).field("fixer").equal(account.getId()).order("donationReceived, -id");
	}

	@Override
    public void save(Object thing) {
        datastore.save(thing);
    }

	@Override
	public Account getAccountByVenmoId(String id) {
		return datastore.find(Account.class).field("token.user.id").equal(id).get();
	}

	@Override
	public Query<Problem> getAvailableProblemsForFixer(Account account) {
		return datastore.find(Problem.class)
				.field("fixer").doesNotExist()
				.field("fixed").notEqual(true)
				.field("tag").hasAnyOf(account.getInterests())
				.order("-id");
	}

	@Override
	public Query<Account> getFixersInterestedInTag(String tag) {
		return datastore.find(Account.class).field("interests").contains(tag);
	}

    public String getJustGivingDonationFormUrl(String charityId, Double price, String problemId) {
        String replacedRedirect = redirectUrl.replace("{problemId}", problemId).replace("{charityId}", charityId);
        String replacedBase = baseJustGivingBase
            .replace("{charityId}", charityId)
            .replace("{amount}", String.format("%.2f", price));
        try {
            return replacedBase.replace("{exitUrl}", URLEncoder.encode(replacedRedirect, "UTF-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
	}
    }

    public void flagDonationOnProblem(String problemId, SearchResult charity) {
        Query<Problem> query = datastore.find(Problem.class)
            .field("id").equal(new ObjectId(problemId));
        UpdateOperations<Problem> update = datastore
            .createUpdateOperations(Problem.class)
            .set("charity", charity)
            .set("donationReceived", true);
        datastore.update(query, update);
    }

	@Override
	public void delete(Object thing) {
		datastore.delete(thing);
	}
}
