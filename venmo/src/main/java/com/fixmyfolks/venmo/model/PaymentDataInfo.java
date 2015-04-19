package com.fixmyfolks.venmo.model;

public class PaymentDataInfo {
    private Double balance;
    private Payment payment;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}
