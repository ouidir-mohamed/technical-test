package com.example.technicaltest.ut;

import com.example.technicaltest.utils.Validator;
import org.junit.Assert;
import org.junit.Test;


public class ValidatorsTest {
    @Test
    public void testPhoneValidator() throws Exception {
        Assert.assertEquals(true, Validator.idPhoneValid("0605278302"));
        Assert.assertEquals(true, Validator.idPhoneValid("0105278302"));
        Assert.assertEquals(true, Validator.idPhoneValid("+33605278302"));
        Assert.assertEquals(false, Validator.idPhoneValid("01052783029"));
        Assert.assertEquals(false, Validator.idPhoneValid("010527830U"));
    }

}
