package com.fixmyfolks.justgiving.model;

import java.math.BigDecimal;

public class DonationStatus {
    public static enum Status {
        Accepted,
        Rejected,
        Cancelled,
        Refunded,
        Pending;
    }

    private BigDecimal amount;
    private String donationId;
    private String donationRef;
    private String ref;
    private Status status;

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getDonationId() {
        return donationId;
    }

    public void setDonationId(String donationId) {
        this.donationId = donationId;
    }

    public String getDonationRef() {
        return donationRef;
    }

    public void setDonationRef(String donationRef) {
        this.donationRef = donationRef;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
