package com.example.technicaltest.ut;

import com.example.technicaltest.utils.DateTimeHelper;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;

public class DateTimeHelperTest {
    @Test
    public void yearsFromTest() {
        Assert.assertEquals(20, DateTimeHelper.yearsFrom(Date.valueOf("2003-02-11")));
        Assert.assertEquals(18, DateTimeHelper.yearsFrom(Date.valueOf("2005-04-17")));

    }
}
