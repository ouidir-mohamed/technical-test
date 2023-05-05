package com.example.technicaltest.controllers;

import com.example.technicaltest.entities.Country;
import com.example.technicaltest.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("countries")
public class CountryController {
    @Autowired
    CountryService countryService;

    /**
     * Called when the endpoint "/countries/" is called.
     *
     * @return Returns the list of all countries.
     */
    @GetMapping("/")
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }
}


