package com.example.technicaltest.ut;

import com.example.technicaltest.utils.Validator;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class ValidatorsTest {
    @Autowired
    Validator validator;

    @Test
    public void testPhoneValidator() throws Exception {
        Assert.assertEquals(true, validator.isPhoneValid("0605278302"));
        Assert.assertEquals(true, validator.isPhoneValid("0105278302"));
        Assert.assertEquals(true, validator.isPhoneValid("+33605278302"));
        Assert.assertEquals(false, validator.isPhoneValid("01052783029"));
        Assert.assertEquals(false, validator.isPhoneValid("010527830U"));
    }

}
