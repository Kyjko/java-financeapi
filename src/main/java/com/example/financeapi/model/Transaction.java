package com.example.financeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.lang.NonNull;

import java.util.UUID;

public class Transaction {

    private final int id;
    private final double amount;
    private final UUID recipientId;
    private final UUID senderId;
    private final String comment;

    public Transaction(int id, @JsonProperty("amount") double amount,
                       @JsonProperty("recipientId") UUID recipientId,
                       @JsonProperty("senderId") UUID senderId,
                       @JsonProperty("comment") String comment) {
        this.id = id;
        this.amount = amount;
        this.recipientId = recipientId;
        this.senderId = senderId;
        this.comment = comment;
    }

    public int getId() {
        return id;
    }

    public double getAmount() {
        return amount;
    }

    public UUID getRecipientId() {

        return recipientId;
    }

    public UUID getSenderId() {
        return senderId;
    }

    public String getComment() {
        return comment;
    }
}
