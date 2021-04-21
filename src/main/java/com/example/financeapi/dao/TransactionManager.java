package com.example.financeapi.dao;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {

    private final long transactionBufferLimit;
    private final UserDao userDao;
    private final List<Transaction> transactionBuffer = new ArrayList<>();

    public TransactionManager(UserDao userDao, long transactionBufferLimit) {
        this.transactionBufferLimit = transactionBufferLimit;
        this.userDao = userDao;
    }

    public long getTransactionBufferLimit() {
        return transactionBufferLimit;
    }

    public int pushTransaction(Transaction tr) {
        transactionBuffer.add(tr);
        if(transactionBuffer.size() >= transactionBufferLimit) {
            executeTransactions();
            return 0;
        }
        return tr.getId();
    }

    public int executeTransactions() {
        transactionBuffer.forEach(tr -> {
            User sender = userDao.getUserById(tr.getSenderId());
            User recipient = userDao.getUserById(tr.getRecipientId());
            sender.setBalance(sender.getBalance() - tr.getAmount());
            recipient.setBalance(recipient.getBalance() + tr.getAmount());

            sender.storeTransaction(tr);
            recipient.storeTransaction(tr);

            userDao.updateUserById(tr.getSenderId(), sender);
            userDao.updateUserById(tr.getRecipientId(), recipient);
        });

        transactionBuffer.clear();

        return 0;
    }
}
