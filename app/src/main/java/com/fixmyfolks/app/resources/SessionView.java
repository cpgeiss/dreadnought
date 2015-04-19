package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

import com.fixmyfolks.data.model.Account;

public class SessionView extends View {

	private Account account;
	
	public SessionView(Account account, String templateName) {
		super(templateName);
		this.account = account;
	}
	
	public Account getAccount() {
		return account;
	}

}