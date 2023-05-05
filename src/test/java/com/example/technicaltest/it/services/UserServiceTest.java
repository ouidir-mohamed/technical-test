package com.example.technicaltest.it.services;

import com.example.technicaltest.entities.Country;
import com.example.technicaltest.entities.User;
import com.example.technicaltest.services.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
import java.util.Optional;

import static org.junit.Assert.assertEquals;


@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(scripts = "/data.sql")

public class UserServiceTest {

    @Autowired // let Spring instantiate the instance to test
    private UserService userService;

    @Test
    public void userServiceTest() {

        // add new user test

        String userName = "user name 1";
        User userData = new User(userName, Date.valueOf("2002-10-13"), new Country("FR", "France"), null, null);
        User result = userService.addUser(userData);
        assertEquals(result, userData);

        // get user test

        Optional<User> userFound = userService.getUserByUserName(userName);
        assertEquals(userFound.get(), userData);

    }
}
