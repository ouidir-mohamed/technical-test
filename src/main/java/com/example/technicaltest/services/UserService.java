package com.example.technicaltest.services;

import com.example.technicaltest.entities.User;
import com.example.technicaltest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public Optional<User> getUserByUserName(String userName) {
        return userRepository.findById(userName);
    }
}



