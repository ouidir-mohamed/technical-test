package com.example.technicaltest.mappers;

import com.example.technicaltest.dto.UserDto;
import com.example.technicaltest.entities.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The class that handles the mapping between UserEntity and UserDto objects
 */
@Component
public class UserMapper {
    @Autowired
    private ModelMapper modelMapper;

    /** Converts a UserEntity object to a UserDto object
     * @param userEntity The UserEntity you want to convert
     * @return Returns a UserDto object
     */
    public UserDto toUserDto(UserEntity userEntity) {
        return modelMapper.map(userEntity, UserDto.class);
    }

    /** Converts a UserDto object to a UserEntity object
     * @param userDto The UserDto object you want to convert
     * @return Returns a UserEntity object
     */
    public UserEntity toUserEntity(UserDto userDto) {
        return modelMapper.map(userDto, UserEntity.class);
    }
}
