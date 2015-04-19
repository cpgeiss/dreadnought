package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.model.Account;

public class ProblemFormView extends SessionView {

	public ProblemFormView(Account account) {
		super(account, "problem_form.ftl");
	}

}
