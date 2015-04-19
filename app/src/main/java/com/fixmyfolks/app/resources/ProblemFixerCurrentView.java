package com.fixmyfolks.app.resources;

import java.util.List;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public class ProblemFixerCurrentView extends SessionView {

	private List<Problem> problems;
	
	public ProblemFixerCurrentView(Account account, List<Problem> problems) {
		super(account, "problem_fixer_current.ftl");
		this.problems = problems;
	}

	public List<Problem> getProblems() {
		return problems;
	}
	
}
