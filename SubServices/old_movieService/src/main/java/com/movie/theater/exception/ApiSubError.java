package com.movie.theater.exception;

import lombok.Data;

@Data
public class ApiSubError {
    private String field;
    private String message;

    public ApiSubError(String field, String message) {
        this.field = field;
        this.message = message;
    }
}
