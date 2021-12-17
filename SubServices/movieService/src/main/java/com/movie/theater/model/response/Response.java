package com.movie.theater.model.response;

import com.movie.theater.model.common.SystemResponse;
import org.springframework.http.ResponseEntity;

public class Response {
    private Response(){}

    public static <T> ResponseEntity<SystemResponse<T>> ok(){
        return ResponseEntity.ok(new SystemResponse<>(200, "OK"));
    }

    public static <T> ResponseEntity<SystemResponse<T>> ok(T body){
        return ResponseEntity.ok(new SystemResponse<>(200, "OK", body));
    }

    public static <T> ResponseEntity<SystemResponse<T>> fail(T body){
        return ResponseEntity.badRequest().body(new SystemResponse<>(400,"fail", body));
    }



}