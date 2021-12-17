package com.authorization_service.model.entity;

import com.authorization_service.model.common.Gender;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
public class Account {
    @Id
    @Column(length = 100)
    private String accountId;

    @Column(nullable = false)
    private String address;

    private LocalDate dateOfBirth;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String fullName;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private String identityCard;

    private String image;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(length = 10, nullable = false)
    private int roleId;

    @Column(length = 1, nullable = false)
    private int status;

    @Column(nullable = false)
    private String username;
}
