package com.fixmyfolks.data;

import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

import com.fixmyfolks.data.model.Folk;
import com.fixmyfolks.data.model.Fixer;
import com.fixmyfolks.data.model.Problem;
import com.mongodb.MongoClient;

public class FixFolkDataImpl implements FixFolkData {
    private Datastore datastore;

    public FixFolkDataImpl(Morphia morphia, MongoClient mongoClient, String dbName) {
        datastore = morphia.createDatastore(mongoClient, dbName);
        datastore.ensureIndexes();
    }

    private void mapClasses(Morphia morphia) {
        morphia.map(
            Folk.class,
            Fixer.class,
            Problem.class
        );
    }

    public Query<Problem> getAllProblems() {
        return datastore.find(Problem.class);
    }

    public Query<Fixer> getAllFixers() {
        return datastore.find(Fixer.class);
    }

    public Query<Folk> getAllFolks() {
        return datastore.find(Folk.class);
    }

    public Folk getFolkById(String id) {
        return datastore.get(Folk.class, new ObjectId(id));
    }

    public Fixer getFixerById(String id) {
        return datastore.get(Fixer.class, new ObjectId(id));
    }

    public Problem getProblemById(String id) {
        return datastore.get(Problem.class, new ObjectId(id));
    }

    public void save(Object thing) {
        datastore.save(thing);
    }
}
