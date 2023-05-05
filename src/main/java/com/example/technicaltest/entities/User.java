package com.example.technicaltest.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    private String userName;
    @Column(nullable = false)
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "country_code")
    private Country countryOfResidence;
    private String phoneNumber;
    @Enumerated(EnumType.ORDINAL)
    private Gender gender;
}


