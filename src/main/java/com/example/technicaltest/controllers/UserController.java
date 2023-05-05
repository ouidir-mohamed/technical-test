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

    /**
     * Called when the endpoint "/user/" is called with POST methode.
     * It calls UserService to register a new user.
     *
     * @param user The user object.
     * @return The registered user.
     */
    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * Called when the endpoint "/user/{userName}" is called with GET methode.
     * It calls UserService to get the registered user with the given username;
     *
     * @param userName The given username
     * @return The registered user.
     */
    @GetMapping("/{userName}/")
    public User getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
