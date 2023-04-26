package com.example.technicaltest.controllers;
import com.example.technicaltest.entities.Country;
import com.example.technicaltest.services.CountryService;
import com.example.technicaltest.utils.DateTimeHelper;
import com.example.technicaltest.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.technicaltest.entities.User;
import com.example.technicaltest.services.UserService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@RestController()
@RequestMapping("users")

public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/")
    public User addUser(@RequestBody User user) {
        if(userService.getUserByUserName(user.getUserName()).isPresent()) throw  new UserNameAlreadyExistsException();
        if(!user.getCountryOfResidence().getCode().equals("FR")) throw new CountryNotAllowedException();
        if(DateTimeHelper.yearsFrom(user.getBirthDate())<18) throw new AgeNotAllowedException();
       if(user.getPhoneNumber()!=null) if(!Validator.idPhoneValid(user.getPhoneNumber())) throw new PhoneNotValidException();
        return userService.addUser(user);
    }


    @GetMapping("/{userName}/")
    public User getUserByUserName(@PathVariable String userName) {
        Optional<User>user= userService.getUserByUserName(userName);
        if (!user.isPresent()) throw new UserNotFoundException();
        return user.get();
    }
}


@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Username already exists")
class UserNameAlreadyExistsException extends RuntimeException { }

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Not allowed Country")
 class CountryNotAllowedException extends RuntimeException { }

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Not allowed age")
class AgeNotAllowedException extends RuntimeException { }

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="Not valid phone number")
class PhoneNotValidException extends RuntimeException{}

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="User not found")
class UserNotFoundException extends RuntimeException{}