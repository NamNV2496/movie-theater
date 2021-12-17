package com.movie.theater.model.response;

import com.movie.theater.model.common.Gender;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountMemberResponse {

    private String accountId;

    private String memberId;

    private String account;

    private String password;

    private String fullName;

    private LocalDate dateOfBirth;

    private Gender gender;

    private String identityCard;

    private String email;

    private String address;

    private String phoneNumber;

    private String image;
}
