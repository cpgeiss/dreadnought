package com.fixmyfolks.app.resources;

import com.fixmyfolks.data.model.Account;

public class GivingCharitiesForm extends SessionView {
    private final String charityDonateUrl;

    public GivingCharitiesForm(Account account, String charityDonateUrl) {
        super(account, "giving_donate_form.ftl");
        this.charityDonateUrl = charityDonateUrl;
    }

    public String getCharityDonateUrl() {
        return charityDonateUrl;
    }
}
