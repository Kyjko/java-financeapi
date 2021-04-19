package com.example.financeapi.model;

import javax.persistence.*;
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

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "s_id", unique = true, nullable = false)
    private int s_id;

    public User(UUID id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
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
}
