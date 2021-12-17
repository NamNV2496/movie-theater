package com.authorization_service.model.request;

import lombok.Data;

@Data
public class AccountRequest {
    private String username;
    private String password;

}
