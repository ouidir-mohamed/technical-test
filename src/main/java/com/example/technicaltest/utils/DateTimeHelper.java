package com.example.technicaltest.utils;

import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.concurrent.TimeUnit;


@Component
public class DateTimeHelper {
    /**
     * Calculate the number of years from a given date until now.
     *
     * @param date The given date.
     * @return The number of years
     */
    public long yearsFrom(Date date) {
        Date today = new Date();
        long diffInMillies = today.getTime() - date.getTime();

        return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) / 365;
    }
}

