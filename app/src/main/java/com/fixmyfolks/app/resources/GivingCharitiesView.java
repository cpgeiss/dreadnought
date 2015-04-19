package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.model.Account;

public class GivingCharitiesView extends SessionView {
    private final String problemId;

    public GivingCharitiesView(Account account, String problemId) {
        super(account, "giving_donate_search.ftl");
        this.problemId = problemId;
    }

    public String getProblemId() {
        return problemId;
    }
}
