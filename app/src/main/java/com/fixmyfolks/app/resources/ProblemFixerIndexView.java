package com.fixmyfolks.app.resources;

import java.util.List;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public class ProblemFixerIndexView extends SessionView {

	private List<Problem> problems;
	
	public ProblemFixerIndexView(Account account, List<Problem> problems) {
		super(account, "problem_fixer_index.ftl");
		this.problems = problems;
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

}