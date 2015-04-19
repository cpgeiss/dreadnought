package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public class FolkScreenShareView extends SessionView {

	private Problem problem;
	
	public FolkScreenShareView(Account account, Problem problem) {
		super(account, "problem_folk_screen_share.ftl");
		this.problem = problem;
	}

	public Problem getProblem() {
		return problem;
	}

}