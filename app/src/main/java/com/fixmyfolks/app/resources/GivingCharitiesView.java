package com.fixmyfolks.app.resources;

import io.dropwizard.views.View;

public class GivingCharitiesView extends View {
    private final String problemId;

    public GivingCharitiesView(String problemId) {
        super("giving_donate_search.ftl");
        this.problemId = problemId;
    }

    public String getProblemId() {
        return problemId;
    }
}
