package com.example.web.exception;

import org.springframework.http.HttpStatus;

import java.io.Serializable;

public class ErrorDetail implements Serializable {
    private final String errorCode;
    private final String description;
    private final HttpStatus statusCode;

    private ErrorDetail(String errorCode, String description, HttpStatus statusCode) {
        this.errorCode = errorCode;
        this.description = description;
        this.statusCode = statusCode;
    }

    public static ErrorDetail of(String errorCode, String description, HttpStatus httpStatus) {
        return new ErrorDetail(errorCode, description, httpStatus);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}