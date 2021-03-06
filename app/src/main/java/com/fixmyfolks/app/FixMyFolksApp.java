package com.fixmyfolks.app;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.configuration.EnvironmentVariableSubstitutor;
import io.dropwizard.configuration.SubstitutingSourceProvider;
import io.dropwizard.jersey.sessions.SessionFactoryProvider;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.dropwizard.views.ViewBundle;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.eclipse.jetty.server.session.SessionHandler;

import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import com.fixmyfolks.app.resources.AccountResource;
import com.fixmyfolks.app.resources.BaseResource;
import com.fixmyfolks.app.resources.GivingResource;
import com.fixmyfolks.app.resources.IndexResource;
import com.fixmyfolks.app.resources.ProblemResource;
import com.fixmyfolks.data.FixFolkData;
import com.fixmyfolks.data.FixFolkDataImpl;
import com.fixmyfolks.justgiving.JustGiving;
import com.fixmyfolks.venmo.Venmo;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class FixMyFolksApp extends Application<AppConfiguration> {

	@Override
	public void run(AppConfiguration configuration, Environment environment) throws Exception {
		Gson gson = new GsonBuilder()
			.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
			.registerTypeAdapter(Date.class, new DateTypeAdapter())
			.create();
		RestAdapter venmoAdapter = new RestAdapter.Builder()
			.setEndpoint(configuration.getVenmoClientEndpoint())
			.setLogLevel(RestAdapter.LogLevel.FULL)
			.setConverter(new GsonConverter(gson))
			.build();
      Gson givingParser = new GsonBuilder()
          .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
          .create();
      RestAdapter givingAdapter = new RestAdapter.Builder()
          .setEndpoint(configuration.getGivingEndpoint())
          .setLogLevel(RestAdapter.LogLevel.FULL)
          .setConverter(new GsonConverter(givingParser))
          .build();
		Venmo venmo = venmoAdapter.create(Venmo.class);
      JustGiving justGiving = givingAdapter.create(JustGiving.class);
      	MongoClient client = null;
      	String clientUri = System.getenv("MONGOLAB_URI");
      	if (clientUri != null) {
      		client = new MongoClient(new MongoClientURI(clientUri));
      	} else {
      		client = new MongoClient();
      	}
		FixFolkData data = new FixFolkDataImpl(client, configuration.getDb())
          .setJustGivingBase(configuration.getBaseJustGivingFormUrl())
          .setRedirectUrl(configuration.getJustGivingRedirectUrl());
		List<BaseResource> resources = Arrays.asList(
				new IndexResource(data, configuration),
				new AccountResource(data, venmo, configuration),
          new GivingResource(data, justGiving, venmo, configuration),
				new ProblemResource(data, configuration));
		for (BaseResource resource : resources) {
			environment.jersey().register(resource);
		}
		
		// Add session support
		environment.jersey().register(SessionFactoryProvider.class);
	    environment.servlets().setSessionHandler(new SessionHandler());
	    
	    // Handle exceptions and redirect to the index page
	    environment.jersey().register(new AuthExceptionMapper());
	}
	
	@Override
	public void initialize(Bootstrap<AppConfiguration> bootstrap) {
		super.initialize(bootstrap);
		bootstrap.addBundle(new ViewBundle<AppConfiguration>());
		bootstrap.addBundle(new AssetsBundle("/assets/"));
		bootstrap.setConfigurationSourceProvider(
				new SubstitutingSourceProvider(bootstrap.getConfigurationSourceProvider(),
						new EnvironmentVariableSubstitutor()));
	}

	public static void main(String[] args) throws Exception {
        new FixMyFolksApp().run(args);
    }

}
