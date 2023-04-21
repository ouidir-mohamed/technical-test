package com.example.technicaltest.utils;

import java.util.Date;
import java.util.concurrent.TimeUnit;


public class DateTimeHelper{
        public static long  yearsFrom(Date date){
            Date today=new Date();
            long diffInMillies=today.getTime()-date.getTime();

            return TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS) /365 ;
        }
    }

