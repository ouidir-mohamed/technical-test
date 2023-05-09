package com.example.technicaltest;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * AppConfig class, it handles third party dependency injection.
 */
@Configuration
public class AppConfig {
    /**
     * Declaring a ModalMapper instance as a Bean, so it can be injected using @Autowired annotation.
     * @return A Model mapper instance.
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
