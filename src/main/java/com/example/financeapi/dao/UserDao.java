package com.example.financeapi.dao;

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
    User getUserById(UUID id);
    User getUserByName(String name);
    int deleteUserById(UUID id);
    int updateUserById(UUID id, User user);
    List<User> getUsers();
}
