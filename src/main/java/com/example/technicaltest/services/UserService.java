package com.example.technicaltest.services;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.entities.UserEntity;
import com.example.technicaltest.exceptions.*;
import com.example.technicaltest.mappers.UserMapper;
import com.example.technicaltest.repositories.UserRepository;
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
    @Autowired
    UserMapper userMapper;

    /**
     * Validates and Registers a new user.
     *
     * @param userDto The User to be registered.
     * @return The registered user.
     */
    public UserDto addUser(UserDto userDto) {
        if (userRepository.findById(userDto.getUserName()).isPresent()) throw new UserNameAlreadyExistsException();
        if (!validator.isCountryAllowed(userDto.getCountryOfResidence())) throw new CountryNotAllowedException();
        if (!validator.isAdult(userDto.getBirthDate())) throw new AgeNotAllowedException();
        if (userDto.getPhoneNumber() != null) {
            if (!validator.isPhoneValid(userDto.getPhoneNumber())) throw new PhoneNotValidException();
        }
        UserEntity userEntity = userMapper.toUserEntity(userDto);
        UserEntity userEntityResult = userRepository.save(userEntity);
        UserDto useDtoResult = userMapper.toUserDto(userEntityResult);
        return useDtoResult;
    }

    /**
     * Fetches a user by his username.
     *
     * @param userName The username.
     * @return The user found.
     */
    public UserDto getUserByUserName(String userName) {
        Optional<UserEntity> userEntity = userRepository.findById(userName);
        if (!userEntity.isPresent()) throw new UserNotFoundException();
        UserDto userDto = userMapper.toUserDto(userEntity.get());
        return userDto;
    }
}



