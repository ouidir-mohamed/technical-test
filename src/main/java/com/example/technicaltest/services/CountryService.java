package com.example.technicaltest.services;

import com.example.technicaltest.entities.Country;
import com.example.technicaltest.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService {
    @Autowired
    CountryRepository countryRepository;

    /**
     * Fetches all countries from country repository.
     *
     * @return The list of all countries.
     */
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }
}



