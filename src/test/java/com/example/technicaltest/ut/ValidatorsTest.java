package com.example.technicaltest.ut;

import com.example.technicaltest.utils.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ValidatorsTest {
    @Autowired
    private Validator validator;

    @Test
    public void testPhoneValidator() throws Exception {
        Assert.assertTrue(validator.isPhoneValid("0605278302"));
        Assert.assertTrue(validator.isPhoneValid("0105278302"));
        Assert.assertTrue(validator.isPhoneValid("+33605278302"));
        Assert.assertFalse(validator.isPhoneValid("01052783029"));
        Assert.assertFalse(validator.isPhoneValid("010527830U"));
    }

    @Test
    public void testIsCountryAllowed() throws Exception {
        Assert.assertTrue(validator.isCountryAllowed("FR"));
        Assert.assertFalse(validator.isCountryAllowed("GB"));
    }

    @Test
    public void testisAdult() throws Exception {
        Assert.assertTrue(validator.isAdult(Date.valueOf("2002-11-05")));
        Assert.assertFalse(validator.isAdult(Date.valueOf("2010-02-08")));
    }

}
