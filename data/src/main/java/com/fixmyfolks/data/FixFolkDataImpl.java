package com.fixmyfolks.data;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;
import com.mongodb.MongoClient;

public class FixFolkDataImpl implements FixFolkData {
    private Datastore datastore;

    public FixFolkDataImpl(MongoClient mongoClient, String dbName) {
        datastore = createMorphia().createDatastore(mongoClient, dbName);
        datastore.ensureIndexes();
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
	public Iterable<Problem> getProblemsForFolk(Account account) {
		return datastore.find(Problem.class).field("folk").equal(account.getId());
	}

	@Override
	public Iterable<Problem> getProblemsForFixer(Account account) {
		return datastore.find(Problem.class).field("fixer").equal(account.getId());
	}

	@Override
    public void save(Object thing) {
        datastore.save(thing);
    }

}
