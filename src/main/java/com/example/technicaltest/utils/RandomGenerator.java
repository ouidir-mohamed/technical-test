package com.example.technicaltest.utils;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomGenerator {

    /**
     * Generates a random string of 24 characters.
     *
     * @return A random string
     */
    public String getRandomString() {
        return getRandomString(24);
    }

    /**
     * Generates a random string of a given length.
     *
     * @param length The string length
     * @return A random string
     */
    public String getRandomString(int length) {
        return new Random().ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
