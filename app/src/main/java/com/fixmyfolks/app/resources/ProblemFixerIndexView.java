package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

import java.util.List;

import com.fixmyfolks.data.model.Problem;

public class ProblemFixerIndexView extends View {

	private List<Problem> problems;
	
	public ProblemFixerIndexView(List<Problem> problems) {
		super("problem_fixer_index.ftl");
		this.problems = problems;
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

}