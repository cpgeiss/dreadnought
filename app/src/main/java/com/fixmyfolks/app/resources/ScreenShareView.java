package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

import com.fixmyfolks.data.model.Problem;

public class ScreenShareView extends View {

	private Problem problem;
	
	public ScreenShareView(Problem problem) {
		super("problem_screen_share.ftl");
		this.problem = problem;
	}

	public Problem getProblem() {
		return problem;
	}

}