package com.fixmyfolks.venmo.model;

import java.util.List;

public class RecentPaymentData {
    private List<Payment> data;

    public List<Payment> getData() {
        return data;
    }

    public void setData(List<Payment> data) {
        this.data = data;
    }
}
