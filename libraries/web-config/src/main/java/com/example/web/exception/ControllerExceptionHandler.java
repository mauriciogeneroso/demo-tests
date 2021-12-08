package com.example.web.exception;

import com.example.exception.DownstreamSystemException;
import com.example.exception.GeneralException;
import com.example.exception.InvalidHeaderException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({InvalidHeaderException.class})
    public ResponseEntity<ErrorResponse> handleInvalidHeaderException(InvalidHeaderException ex) {
        return ResponseEntity
                .status(HttpStatus.NOT_ACCEPTABLE)
                .contentType(APPLICATION_JSON)
                .build();
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> handleExceptions(Exception ex) {
        return meoErrorResponse(ErrorDetail.of("OVP_00100", "Unexpected Exception", INTERNAL_SERVER_ERROR));
    }

    @ExceptionHandler(GeneralException.class)
    public ResponseEntity<ErrorResponse> handleMeoException(GeneralException ex) {
        ErrorResponse errorMessage = new ErrorResponse(ex.getMeoError(), ex.getMessage());
        return ResponseEntity
                .status(ex.getMeoError().getStatusCode())
                .contentType(APPLICATION_JSON)
                .body(errorMessage);
    }

    @ExceptionHandler(DownstreamSystemException.class)
    public ResponseEntity<ErrorResponse> handleDownstreamSystemException(DownstreamSystemException ex) {
        return ResponseEntity
                .status(ex.getError().getStatusCode())
                .contentType(APPLICATION_JSON)
                .body(new ErrorResponse(ex));
    }

    private ResponseEntity<ErrorResponse> meoErrorResponse(ErrorDetail meoError) {
        return ResponseEntity
                .status(meoError.getStatusCode())
                .contentType(APPLICATION_JSON)
                .body(new ErrorResponse(meoError));
    }
}
