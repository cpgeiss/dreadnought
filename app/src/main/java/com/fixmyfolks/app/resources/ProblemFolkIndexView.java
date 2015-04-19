package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

import java.util.List;

import com.fixmyfolks.data.model.Problem;

public class ProblemFolkIndexView extends View {

	private List<Problem> problems;
	
	public ProblemFolkIndexView(List<Problem> problems) {
		super("problem_folk_index.ftl");
		this.problems = problems;
	}
	
	public List<Problem> getProblems() {
		return problems;
	}

}