package com.example.technicaltest.utils;

import java.util.Random;

public class RandomGenerator {


    public static String getRandomString() {
        return getRandomString(24);
    }

    public static String getRandomString(int length) {
        return new Random().ints(97, 123)
                .limit(length)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }

}
