package com.example.financeapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import java.util.UUID;

@Entity
@Table(name = "users")
public class User {
    @Column(name = "id", nullable = false)
    private final UUID id;

    @Column(name = "name", nullable = false)
    private final String name;

    @Column(name = "password")
    private final String password;

    @Column(name = "balance")
    private double balance;

    private final List<Transaction> transactionHistory = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id", unique = true, nullable = false)
    private int s_id;

    public User(@JsonProperty("id") UUID id, @JsonProperty("name") String name,
                @JsonProperty("password") String password, @JsonProperty("balance") double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    public void setBalance(double b) {
        this.balance = b;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public String toString() {
        return "Username: " + name + "\nPassword: " + password + "\nId: " + id.toString();
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public void storeTransaction(Transaction tr) {
        transactionHistory.add(tr);
    }

    public int getS_id() {
        return s_id;
    }

    public double getBalance() {
        return balance;
    }
}
