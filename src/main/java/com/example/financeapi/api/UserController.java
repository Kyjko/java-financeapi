package com.example.financeapi.api;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;
import com.example.financeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/api/v1/users/get")
    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @RequestMapping("/api/v1/users/delete")
    @DeleteMapping(path = "{id}")
    public int deleteUserById(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }

    @RequestMapping("/api/v1/users")
    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping("/api/v1/users/update")
    @PutMapping(path = "{id}")
    public int updateUserById(@PathVariable("id") UUID id, @RequestBody final User user) {
        return userService.updateUserById(id, user);
    }

    @RequestMapping("/api/v1/users/transactions/get")
    @GetMapping(path = "{id}")
    public List<Transaction> getTransactionHistoryOfUser(@PathVariable("id") UUID id) {
        return userService.getTransactionHistoryOfUser(id);
    }

    @RequestMapping("/api/v1/transactions")
    @GetMapping
    public List<Transaction> getTransactionHistory() {
        return userService.getTransactionHistory();
    }

    @RequestMapping("/api/v1/transactions/push")
    @PostMapping
    public int pushTransaction(@RequestBody final Transaction tr) {
        return userService.pushTransaction(tr);
    }

    @RequestMapping("/api/v1/users/add")
    @PostMapping
    public int addUser(@RequestBody final User user) {
        return userService.addUser(user);
    }

}
