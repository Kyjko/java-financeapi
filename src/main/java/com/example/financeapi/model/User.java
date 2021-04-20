package com.example.financeapi.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
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

    public User(UUID id, String name, String password, double balance) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.balance = balance;
    }

    private void setBalance(double b) {
        this.balance = b;
    }

    public void executeTransaction(Transaction tr) {
        if(tr.getSender().getId().equals(this.getId())) {
            double trAmount = tr.getAmount();
            if(balance >= trAmount) {
                this.setBalance(this.getBalance()-trAmount);
                tr.getRecipient().setBalance(tr.getRecipient().getBalance()+trAmount);
                transactionHistory.add(tr);
                tr.getRecipient().transactionHistory.add(tr);
            }
        } else if(tr.getRecipient().getId().equals(this.getId())) {
            double trAmount = tr.getAmount();
            this.setBalance(this.getBalance() + trAmount);
            tr.getSender().setBalance(tr.getSender().getBalance()-trAmount);
            transactionHistory.add(tr);
            tr.getSender().transactionHistory.add(tr);
        } else if(tr.getRecipient().getId().equals(tr.getSender().getId())) {
            // TODO: something
        }
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

    public int getS_id() {
        return s_id;
    }

    public double getBalance() {
        return balance;
    }
}
