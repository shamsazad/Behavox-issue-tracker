package com.behavox.issuetracker.exception;

import org.springframework.http.HttpStatus;

public class InvalidStateTransitionOfBug extends RuntimeException {

    private final HttpStatus statusCode;

    private final ErrorResponse errorResponse;

    public InvalidStateTransitionOfBug(String message) {
        super(message);
        this.statusCode = null;
        errorResponse = null;
    }

    public InvalidStateTransitionOfBug(String message, HttpStatus statusCode, ErrorResponse errorResponse) {
        super(message);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public InvalidStateTransitionOfBug(String message, Throwable cause, HttpStatus statusCode, ErrorResponse errorResponse) {
        super(message, cause);
        this.statusCode = statusCode;
        this.errorResponse = errorResponse;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public ErrorResponse getErrorResponse() {
        return errorResponse;
    }
}
