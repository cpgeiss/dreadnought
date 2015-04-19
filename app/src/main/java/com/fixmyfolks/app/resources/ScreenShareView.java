package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public class ScreenShareView extends SessionView {

	private Problem problem;
	
	public ScreenShareView(Account account, Problem problem) {
		super(account, "problem_screen_share.ftl");
		this.problem = problem;
	}

	public Problem getProblem() {
		return problem;
	}

}