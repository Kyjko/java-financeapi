package com.example.financeapi.service;

import com.example.financeapi.dao.UserDao;
import com.example.financeapi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserDao userDao;

    @Autowired
    public UserService(@Qualifier("in_memory") UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(UUID id) {
        return userDao.getUserById(id);
    }

    public int deleteUserById(UUID id) {
        return userDao.deleteUserById(id);
    }

    public User getUserByName(String name) {
        return userDao.getUserByName(name);
    }

    public List<User> getUsers() {
        return userDao.getUsers();
    }

    public int updateUserById(UUID id, User user) {
        return userDao.updateUserById(id, user);
    }

    public int addUser(User user) {

        return userDao.addUser(user);
    }

}
