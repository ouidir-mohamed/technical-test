package com.example.technicaltest.mappers;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    public UserDto toUserDto(UserEntity userEntity){
    return modelMapper.map(userEntity,UserDto.class);
}
    public UserEntity toUserEntity(UserDto userDto){
        return modelMapper.map(userDto,UserEntity.class);
    }
}
