package com.example.technicaltest.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {

    public static boolean idPhoneValid(String phone) {
        Pattern pattern = Pattern.compile("^(?:(?:\\+|00)33|0)\\s*[1-9](?:[\\s.-]*\\d{2}){4}$");
        Matcher matcher = pattern.matcher(phone);
        return matcher.matches();
    }
}
