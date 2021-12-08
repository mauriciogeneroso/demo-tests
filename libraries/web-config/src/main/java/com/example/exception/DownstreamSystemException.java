package com.example.exception;

import com.example.web.exception.ErrorDetail;
import org.springframework.http.HttpStatus;

public class DownstreamSystemException extends RuntimeException {

    private final int downstreamResponseCode;
    private final ErrorDetail error;

    public DownstreamSystemException(ErrorDetail error, String description, int downstreamResponseCode) {
        super(description);
        this.error = error;
        this.downstreamResponseCode = downstreamResponseCode;
    }

    public DownstreamSystemException(ErrorDetail meoError) {
        super(meoError.getDescription());
        this.error = meoError;
        this.downstreamResponseCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public DownstreamSystemException(ErrorDetail meoError, int downstreamResponseCode) {
        this(meoError, meoError.getDescription(), downstreamResponseCode);
    }

    public DownstreamSystemException(ErrorDetail meoError, String description) {
        super(description);
        this.error = meoError;
        this.downstreamResponseCode = HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    public int getDownstreamResponseCode() {
        return downstreamResponseCode;
    }

    public ErrorDetail getError() {
        return error;
    }
}