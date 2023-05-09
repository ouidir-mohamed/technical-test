package com.example.technicaltest.it.services;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.services.UserService;
import com.example.technicaltest.utils.RandomGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest

public class UserServiceTest {

    @Autowired // let Spring instantiate the instance to test
    private UserService userService;
    @Autowired
    private RandomGenerator randomGenerator;

    @Test
    public void userServiceTest() {

        // add new user test
        String userName = randomGenerator.getRandomString();
        UserDto userData = new UserDto(userName, Date.valueOf("2002-10-13"), "France", null, null);
        UserDto result = userService.addUser(userData);
        assertEquals(result, userData);

        // get user test

        UserDto userFound = userService.getUserByUserName(userName);
        assertEquals(userFound, userData);

    }
}
