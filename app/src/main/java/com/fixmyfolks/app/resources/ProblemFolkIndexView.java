package com.fixmyfolks.app.resources;

import java.util.List;

import com.fixmyfolks.data.model.Account;
import com.fixmyfolks.data.model.Problem;

public class ProblemFolkIndexView extends SessionView {

	private List<Problem> problems;
	
	public ProblemFolkIndexView(Account account, List<Problem> problems) {
		super(account, "problem_folk_index.ftl");
		this.problems = problems;
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

}