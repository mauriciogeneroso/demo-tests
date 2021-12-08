package com.example.web.exception;

import com.example.exception.DownstreamSystemException;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.HashMap;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ErrorResponse {

    @JsonAlias(value = "errorcode")
    private String errorCode;

    @JsonAlias(value = "message")
    private String description;

    @JsonIgnore
    private Map<String, String> headers = new HashMap<>();

    public ErrorResponse() {

    }

    public ErrorResponse(String errorCode, String description, Map<String, String> headers) {
        this.errorCode = errorCode;
        this.description = description;
        this.headers = headers;
    }

    public ErrorResponse(ErrorDetail error) {
        this.errorCode = error.getErrorCode();
        this.description = error.getDescription();
    }

    public ErrorResponse(DownstreamSystemException downstreamException) {
        this.errorCode = downstreamException.getError().getErrorCode();
        this.description = downstreamException.getMessage();
    }

    public ErrorResponse(ErrorDetail error, String messageDetail) {
        this.errorCode = error.getErrorCode();
        this.description = String.format(error.getDescription(), messageDetail);
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "errorCode='" + errorCode + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
