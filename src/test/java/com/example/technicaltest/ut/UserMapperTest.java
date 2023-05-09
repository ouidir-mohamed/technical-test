package com.example.technicaltest.ut;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.entities.Gender;
import com.example.technicaltest.entities.UserEntity;
import com.example.technicaltest.mappers.UserMapper;
import com.example.technicaltest.utils.RandomGenerator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserMapperTest {
    @Autowired
    UserMapper userMapper;
    @Autowired
    private RandomGenerator randomGenerator;

    @Test
    public void toUserDtoTest() {
        String userName=randomGenerator.getRandomString();
        UserEntity userEntity=new UserEntity(userName,Date.valueOf("1995-02-18"),"France","0605212121", Gender.MALE);
       UserDto userDto= userMapper.toUserDto(userEntity);

        assertEquals(userDto.getUserName(),userEntity.getUserName());
        assertEquals(userDto.getBirthDate(),userEntity.getBirthDate());
        assertEquals(userDto.getCountryOfResidence(),userEntity.getCountryOfResidence());
        assertEquals(userDto.getPhoneNumber(),userEntity.getPhoneNumber());
        assertEquals(userDto.getGender(),userEntity.getGender());


    }

    @Test
    public void toUserEntityTest() {
        String userName=randomGenerator.getRandomString();
        UserDto userDto=new UserDto(userName,Date.valueOf("1995-02-18"),"France","0605212121", Gender.MALE);
        UserEntity userEntity= userMapper.toUserEntity(userDto);

        assertEquals(userEntity.getUserName(),userDto.getUserName());
        assertEquals(userEntity.getBirthDate(),userDto.getBirthDate());
        assertEquals(userEntity.getCountryOfResidence(),userDto.getCountryOfResidence());
        assertEquals(userEntity.getPhoneNumber(),userDto.getPhoneNumber());
        assertEquals(userEntity.getGender(),userDto.getGender());
    }
}
