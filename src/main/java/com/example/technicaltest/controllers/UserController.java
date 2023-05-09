package com.example.technicaltest.controllers;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * The class that handles /users/ endpoints.
 */
@RestController()
@RequestMapping("users")
public class UserController {
    @Autowired
    UserService userService;

    /**
     * Called when the endpoint "/user/" is called with POST methode.
     * It calls UserService to register a new user.
     *
     * @param userDto The user object.
     * @return The registered user.
     */
    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserDto addUser(@RequestBody UserDto userDto) {
        return userService.addUser(userDto);
    }

    /**
     * Called when the endpoint "/user/{userName}" is called with GET methode.
     * It calls UserService to get the registered user with the given username;
     *
     * @param userName The given username
     * @return The registered user.
     */
    @GetMapping("/{userName}/")
    public UserDto getUserByUserName(@PathVariable String userName) {
        return userService.getUserByUserName(userName);
    }
}
