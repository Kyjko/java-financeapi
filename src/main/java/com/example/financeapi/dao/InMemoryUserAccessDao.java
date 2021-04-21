package com.example.financeapi.dao;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository("in_memory")
public class InMemoryUserAccessDao implements UserDao {

    private static final List<User> userDB = new ArrayList<>();
    private static final List<Transaction> transactionHistory = new ArrayList<>();
    private static TransactionManager trManager;

    public InMemoryUserAccessDao() {
        trManager = new TransactionManager(this, 1);
    }

    @Override
    public List<User> getUsers() {
        return userDB;
    }
    @Override
    public User getUserById(UUID id) {
        return userDB.stream().filter(u -> u.getId().equals(id)).findFirst().orElse(null);
    }
    @Override
    public User getUserByName(String name) {
        return userDB.stream().filter(u -> u.getName().equals(name)).findFirst().orElse(null);
    }
    @Override
    public int deleteUserById(UUID id) {
        User toDelete = getUserById(id);
        if(toDelete != null) {
            userDB.remove(toDelete);
            return 1;
        }
        return 0;
    }
    @Override
    public int updateUserById(UUID id, User user) {
        int index = userDB.indexOf(getUserById(id));
        if(index >= 0) {
            userDB.set(index, user);
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public int insertUser(UUID id, User user) {
        User toInsert = new User(id, user.getName(), user.getPassword(), user.getBalance());
        userDB.add(toInsert);
        return 0;
    }

    @Override
    public List<Transaction> getTransactionHistoryOfUser(UUID id) {
        return getUserById(id).getTransactionHistory();
    }

    @Override
    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    @Override
    public int pushTransaction(Transaction tr) {
        trManager.pushTransaction(tr);
        transactionHistory.add(tr);
        return 0;
    }

}
