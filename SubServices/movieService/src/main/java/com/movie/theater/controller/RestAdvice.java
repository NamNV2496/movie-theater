package com.movie.theater.controller;

import com.movie.theater.exception.ApiError;
import com.movie.theater.exception.ApiSubError;
import com.movie.theater.exception.AppException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class RestAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        logger.info("Invalid arguments found : " + ex.getMessage());
        List<ApiSubError> errors = ex.getBindingResult().getFieldErrors().stream().map(x
                -> new ApiSubError(x.getField(), x.getDefaultMessage())).collect(Collectors.toList());

        String error = "bad request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, errors, ex));
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
                                                                  HttpHeaders headers, HttpStatus status, WebRequest request) {
        String error = "Malformed JSON request";
        return buildResponseEntity(new ApiError(HttpStatus.BAD_REQUEST, error, ex));
    }

    @ExceptionHandler(AppException.class)
    protected ResponseEntity<Object> handleApiError(AppException ex){
        return buildResponseEntity(ex.getApiError());
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleApiError(Exception e){
        ApiError apiError = new ApiError(HttpStatus.BAD_GATEWAY);
        apiError.setMessage(e.getMessage());
        return  buildResponseEntity(apiError);
    }

    private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
        return new ResponseEntity<>(apiError, apiError.getStatus());
    }

    //    @ExceptionHandler(EntityNotFoundException.class)
//    protected ResponseEntity<Object> handleEntityNotFound(
//            EntityNotFoundException ex) {
//        ApiError apiError = new ApiError(HttpStatus.NOT_FOUND);
//        apiError.setMessage(ex.getMessage());
//        return buildResponseEntity(apiError);
//    }

}