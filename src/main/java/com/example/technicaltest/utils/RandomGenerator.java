package com.example.technicaltest.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
@Component
public class RandomGenerator {

    public  String getRandomString() {
        return getRandomString(24);
    }

    public  String getRandomString(int length) {
        return new Random().ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
