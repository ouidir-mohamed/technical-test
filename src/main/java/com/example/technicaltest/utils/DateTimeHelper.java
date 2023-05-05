package com.example.technicaltest.utils;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Component
public class DateTimeHelper {
    public  long yearsFrom(Date date) {
        Date today = new Date();
        long diffInMillies = today.getTime() - date.getTime();

        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
    }
}

