package com.example.technicaltest.repositories;

import com.example.technicaltest.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> { }
