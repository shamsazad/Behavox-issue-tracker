package com.behavox.issuetracker.exception;

import org.springframework.http.HttpStatus;

public class ErrorResponseFactory {

    private static final String ILLEGAL_STATE_TRANSITION = "illegal.state.transition.bug";
    private static final String BAD_REQUEST_USER = "user.missing";
    private static final String ENTITY_MISSING = "entity.missing";
    private static final String INTERNAL_SERVER_ERROR = "internal.server.error";
    private static final String BAD_REQUEST = "bad.request.error";

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

    public static ErrorResponse buildEntityNotFoundException(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(ENTITY_MISSING)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }

    public static ErrorResponse buildForgienKeyConstraintException(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(ENTITY_MISSING)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }

    public static ErrorResponse buildInternalServerError(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .code(INTERNAL_SERVER_ERROR)
                .type(HttpStatus.INTERNAL_SERVER_ERROR.name())
                .message(message)
                .build();
    }

    public static ErrorResponse buildBadRequestException(String message) {

        return ErrorResponse.builder()
                .status(HttpStatus.BAD_REQUEST)
                .code(BAD_REQUEST)
                .type(HttpStatus.BAD_REQUEST.name())
                .message(message)
                .build();
    }
}

