package com.example.technicaltest.dto;

import com.example.technicaltest.entities.Gender;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.sql.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    @Id
    private String userName;
    @Column(nullable = false)
    private Date birthDate;
    private String countryOfResidence;
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}

