package com.example.exception;

import com.example.web.exception.ErrorDetail;

public class GeneralException extends RuntimeException {

    private ErrorDetail meoError;

    public GeneralException(ErrorDetail meoError) {
        super(meoError.getDescription());
        this.meoError = meoError;
    }

    public GeneralException(ErrorDetail meoError, String description) {
        super(description);
        this.meoError = meoError;
    }

    public ErrorDetail getMeoError() {
        return meoError;
    }
}
