package com.example.technicaltest.utils;

import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
@Component
public class Validator {

    public boolean isCountryAllowed(String countryCode){
        return countryCode.equals("FR");
    }

    public boolean isAdult(Date birthDate){
        return DateTimeHelper.yearsFrom(birthDate) >= 18;
    }

    public  boolean isPhoneValid(String phone) {
        Pattern pattern = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }


}
