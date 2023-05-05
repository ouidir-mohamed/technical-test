package com.example.technicaltest.it.controllers;

import com.example.technicaltest.entities.Country;
import com.example.technicaltest.entities.Gender;
import com.example.technicaltest.entities.User;
import com.example.technicaltest.utils.RandomGenerator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.sql.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@Sql(scripts = "/data.sql")

public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private RandomGenerator randomGenerator;

    @Test
    public void testUserController() throws Exception {

        // a user without gender and phone
        String userName1 = randomGenerator.getRandomString();
        User user1 = new User(userName1, Date.valueOf("2002-12-05"), new Country("FR", "France"), null, null);
        expectUserAddSuccess(user1);

        // same userName
        User user2 = new User(userName1, Date.valueOf("2002-12-05"), new Country("FR", "France"), null, null);
        expectUserAddFailure(user2);

        // a user with gender and valid phone
        String userName3 = randomGenerator.getRandomString();
        User user3 = new User(userName3, Date.valueOf("2002-12-05"), new Country("FR", "France"), "0605123698", Gender.FEMALE);
        expectUserAddSuccess(user3);

        // a user with gender and invalid phone
        String userName4 = randomGenerator.getRandomString();
        User user4 = new User(userName4, Date.valueOf("2002-12-05"), new Country("FR", "France"), "060512369899", Gender.MALE);
        expectUserAddFailure(user4);

        // a user outside France
        String userName5 = randomGenerator.getRandomString();
        User user5 = new User(userName5, Date.valueOf("2002-12-05"), new Country("DZ", "Algeria"), "0605123698", Gender.MALE);
        expectUserAddFailure(user5);


        // a user below 18 years old
        String userName6 = randomGenerator.getRandomString();
        User user6 = new User(userName6, Date.valueOf("2008-12-05"), new Country("FR", "France"), "0605123698", Gender.MALE);
        expectUserAddFailure(user6);


        //  check if user3 exists
        expectUserExists(userName3);

        //  check if user6 doesn't exists
        expectUserNotExists(userName6);

    }

    public void expectUserAddSuccess(User user) throws Exception {

        this.mockMvc.perform(post("/users/").content(new ObjectMapper().writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is2xxSuccessful());
    }

    public void expectUserAddFailure(User user) throws Exception {

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

