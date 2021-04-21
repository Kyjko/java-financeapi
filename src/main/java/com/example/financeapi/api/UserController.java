package com.example.financeapi.api;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;
import com.example.financeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/v1")
@CrossOrigin
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/get/{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/users/delete/{id}")
    public int deleteUserById(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping("/users/update/{id}")
    public int updateUserById(@PathVariable("id") UUID id, @RequestBody final User user) {
        return userService.updateUserById(id, user);
    }

    @GetMapping("/users/transactions/get{id}")
    public List<Transaction> getTransactionHistoryOfUser(@PathVariable("id") UUID id) {
        return userService.getTransactionHistoryOfUser(id);
    }

    @GetMapping("/transactions")
    public List<Transaction> getTransactionHistory() {
        return userService.getTransactionHistory();
    }

    @PostMapping("/transactions/push")
    public int pushTransaction(@RequestBody final Transaction tr) {
        return userService.pushTransaction(tr);
    }

    @PostMapping("/users/add")
    public int addUser(@RequestBody final User user) {
        return userService.addUser(user);
    }

}
