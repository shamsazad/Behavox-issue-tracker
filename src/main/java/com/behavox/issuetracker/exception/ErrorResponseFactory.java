package com.behavox.issuetracker.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponseFactory {

    private static final String ILLEGAL_STATE_TRANSITION = "illegal.state.transition.bug";
    private static final String BAD_REQUEST_USER = "user.missing";

    public static ErrorResponse buildBadRequestInvalidErrorResponse(String message) {
        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(ILLEGAL_STATE_TRANSITION)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }

    public static ErrorResponse buildBadRequestInvalidUserResponse(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(BAD_REQUEST_USER)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }

    public static ErrorResponse buildBadRequestInvalidStateTransition(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(ILLEGAL_STATE_TRANSITION)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }
}

