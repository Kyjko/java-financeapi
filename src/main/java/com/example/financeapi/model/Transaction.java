package com.example.financeapi.model;

import org.springframework.lang.NonNull;

public class Transaction {

    private final int id;
    private final double amount;
    private User recipient;
    private final User sender;
    private final String comment;

    public Transaction(@NonNull int id, double amount, User recipient, User sender, String comment) {
        this.id = id;
        this.amount = amount;
        this.recipient = recipient;
        this.sender = sender;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public User getRecipient() {
        return recipient;
    }

    public User getSender() {
        return sender;
    }

    public String getComment() {
        return comment;
    }
}
