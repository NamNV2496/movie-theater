package com.movie.theater.model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.movie.theater.model.common.Gender;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class AccountRequest {
    @NotBlank
    @Size(min = 2)
    private String account;

    @NotBlank
    private String password;

    @NotBlank
    private String fullName;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;

    private Gender gender;

    @NotBlank
    private String identityCard;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    private String image;

    @NotBlank
    private String phoneNumber;
}
