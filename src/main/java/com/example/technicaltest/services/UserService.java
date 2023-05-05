package com.example.technicaltest.services;

import com.example.technicaltest.entities.User;
import com.example.technicaltest.exceptions.*;
import com.example.technicaltest.repositories.UserRepository;
import com.example.technicaltest.utils.DateTimeHelper;
import com.example.technicaltest.utils.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    Validator validator;

    public User addUser(User user) {
        if (userRepository.findById(user.getUserName()).isPresent()) throw new UserNameAlreadyExistsException();
        if (!validator.isCountryAllowed(user.getCountryOfResidence().getCode())) throw new CountryNotAllowedException();
        if (!validator.isAdult(user.getBirthDate())) throw new AgeNotAllowedException();
        if (user.getPhoneNumber() != null)
            if (!validator.isPhoneValid(user.getPhoneNumber())) throw new PhoneNotValidException();
        return userRepository.save(user);
    }

    public User getUserByUserName(String userName) {
        Optional<User> user = userRepository.findById(userName);
        if (!user.isPresent()) throw new UserNotFoundException();
        return user.get();
    }
}



