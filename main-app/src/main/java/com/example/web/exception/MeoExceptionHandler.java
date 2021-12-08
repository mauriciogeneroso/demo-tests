package com.example.web.exception;

import com.example.exception.InvalidHeaderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@ControllerAdvice
public class MeoExceptionHandler extends ControllerExceptionHandler {

    @ExceptionHandler({RandomException.class})
    public ResponseEntity<ErrorResponse> handleInvalidHeaderException(RandomException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(APPLICATION_JSON)
                .body(new ErrorResponse(ErrorDetail.of("OVP_0000", ex.getMessage(), HttpStatus.NOT_IMPLEMENTED)));
    }
}
