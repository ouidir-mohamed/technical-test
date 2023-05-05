package com.example.technicaltest.controllers;

import com.example.technicaltest.entities.User;
import com.example.technicaltest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("users")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/{userName}/")
    public User getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
