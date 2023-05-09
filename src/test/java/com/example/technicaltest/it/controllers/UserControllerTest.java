package com.example.technicaltest.it.controllers;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.entities.Gender;
import com.example.technicaltest.utils.RandomGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RandomGenerator randomGenerator;

    @Test
    public void testUserController() throws Exception {

        // a user without gender and phone
        String userName1 = randomGenerator.getRandomString();
        UserDto user1 = new UserDto(userName1, Date.valueOf("2002-12-05"), "France", null, null);
        expectUserAddSuccess(user1);

        // same userName
        UserDto user2 = new UserDto(userName1, Date.valueOf("2002-12-05"), "France", null, null);
        expectUserAddFailure(user2);

        // a user with gender and valid phone
        String userName3 = randomGenerator.getRandomString();
        UserDto user3 = new UserDto(userName3, Date.valueOf("2002-12-05"), "France", "0605123698", Gender.FEMALE);
        expectUserAddSuccess(user3);

        // a user with gender and invalid phone
        String userName4 = randomGenerator.getRandomString();
        UserDto user4 = new UserDto(userName4, Date.valueOf("2002-12-05"), "France", "060512369899", Gender.MALE);
        expectUserAddFailure(user4);

        // a user outside France
        String userName5 = randomGenerator.getRandomString();
        UserDto user5 = new UserDto(userName5, Date.valueOf("2002-12-05"), "Algeria", "0605123698", Gender.MALE);
        expectUserAddFailure(user5);


        // a user below 18 years old
        String userName6 = randomGenerator.getRandomString();
        UserDto user6 = new UserDto(userName6, Date.valueOf("2008-12-05"), "France", "0605123698", Gender.MALE);
        expectUserAddFailure(user6);


        //  check if user3 exists
        expectUserExists(userName3);

        //  check if user6 doesn't exists
        expectUserNotExists(userName6);

    }

    public void expectUserAddSuccess(UserDto user) throws Exception {

        this.mockMvc.perform(post("/users/").content(new ObjectMapper().writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    public void expectUserAddFailure(UserDto user) throws Exception {

        this.mockMvc.perform(post("/users/").content(new ObjectMapper().writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

    public void expectUserExists(String userName) throws Exception {

        this.mockMvc.perform(get("/users/" + userName + "/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    public void expectUserNotExists(String userName) throws Exception {

        this.mockMvc.perform(get("/users/" + userName + "/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError());
    }

}

