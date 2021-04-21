package com.example.financeapi.dao;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

public interface UserDao {
    int insertUser(UUID id, User user);
    default int addUser(User user) {
        UUID id = UUID.randomUUID();
        return insertUser(id, user);
    }
    List<Transaction> getTransactionHistoryOfUser(UUID id);
    List<Transaction> getTransactionHistory();

    int pushTransaction(Transaction tr);
    User getUserById(UUID id);
    User getUserByName(String name);
    int deleteUserById(UUID id);
    int updateUserById(UUID id, User user);
    List<User> getUsers();
}
