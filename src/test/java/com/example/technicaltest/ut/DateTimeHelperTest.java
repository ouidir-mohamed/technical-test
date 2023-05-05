package com.example.technicaltest.ut;

import com.example.technicaltest.utils.DateTimeHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;
@SpringBootTest
@RunWith(SpringRunner.class)
public class DateTimeHelperTest {
    @Autowired
    private DateTimeHelper dateTimeHelper;

    @Test
    public void yearsFromTest() {
        Assert.assertEquals(20, dateTimeHelper.yearsFrom(Date.valueOf("2003-02-11")));
        Assert.assertEquals(18, dateTimeHelper.yearsFrom(Date.valueOf("2005-04-17")));
    }
}
