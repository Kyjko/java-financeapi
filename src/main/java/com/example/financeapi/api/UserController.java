package com.example.financeapi.api;

import com.example.financeapi.model.Transaction;
import com.example.financeapi.model.User;
import com.example.financeapi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin
@RequestMapping("/api/v1/users")
@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "{id}")
    public User getUserById(@PathVariable("id") UUID id) {
        return userService.getUserById(id);
    }

    @GetMapping(path = "{name}")
    public User getUserByName(@PathVariable("name") String name) {
        return userService.getUserByName(name);
    }

    @DeleteMapping(path = "{id}")
    public int deleteUserById(@PathVariable("id") UUID id) {
        return userService.deleteUserById(id);
    }

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PutMapping(path = "{id}")
    public int updateUserById(@PathVariable("id") UUID id, @RequestBody final User user) {
        return userService.updateUserById(id, user);
    }

    @RequestMapping("/api/v1/users/transactions")
    @GetMapping(path = "{id}")
    public List<Transaction> getTransactionHistoryOfUser(@PathVariable("id") UUID id) {
        return userService.getTransactionHistoryOfUser(id);
    }

    @PostMapping
    public int addUser(@RequestBody final User user) {
        return userService.addUser(user);
    }

}
