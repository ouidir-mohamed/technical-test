package com.example.technicaltest.it.services;

import com.example.technicaltest.entities.Country;
import com.example.technicaltest.services.CountryService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountryServiceTest {

    @Autowired
    CountryService countryService;

    @Test
    public void countryServiceTest(){
        List<Country> countries=countryService.getAllCountries();
        assertFalse(countries.isEmpty());
    }
}
