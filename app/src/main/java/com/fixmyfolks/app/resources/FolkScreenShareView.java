package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

import com.fixmyfolks.data.model.Problem;

public class FolkScreenShareView extends View {

	private Problem problem;
	
	public FolkScreenShareView(Problem problem) {
		super("problem_folk_screen_share.ftl");
		this.problem = problem;
	}

	public Problem getProblem() {
		return problem;
	}

}