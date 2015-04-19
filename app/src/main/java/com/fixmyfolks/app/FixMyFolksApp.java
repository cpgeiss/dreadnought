package com.fixmyfolks.app;

import io.dropwizard.Application;
import io.dropwizard.jersey.sessions.SessionFactoryProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Arrays;
import java.util.List;

import org.eclipse.jetty.server.session.SessionHandler;

import com.fixmyfolks.app.resources.AccountResource;
import com.fixmyfolks.app.resources.BaseResource;
import com.fixmyfolks.app.resources.IndexResource;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.FixFolkDataImpl;
import com.mongodb.MongoClient;

public class FixMyFolksApp extends Application<AppConfiguration> {

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws Exception {
		FixFolkData data = new FixFolkDataImpl(new MongoClient(), configuration.getDb());
		List<BaseResource> resources = Arrays.asList(
				new IndexResource(data, configuration.getVenmoClientId(), configuration.getVenmoClientSecret()),
				new AccountResource(data));
		for (BaseResource resource : resources) {
			environment.jersey().register(resource);
		}
		
		// Add session support
		environment.jersey().register(SessionFactoryProvider.class);
	    environment.servlets().setSessionHandler(new SessionHandler());
	}
	
	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		super.initialize(bootstrap);
		bootstrap.addBundle(new ViewBundle<AppConfiguration>());
	}

	public static void main(String[] args) throws Exception {
        new FixMyFolksApp().run(args);
    }

}