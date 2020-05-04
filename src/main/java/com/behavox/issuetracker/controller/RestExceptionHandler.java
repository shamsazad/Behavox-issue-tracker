package com.behavox.issuetracker.controller;

import com.behavox.issuetracker.exception.ErrorResponse;
import com.behavox.issuetracker.exception.ErrorResponseFactory;
import com.behavox.issuetracker.exception.InvalidStateTransitionOfBug;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static String USER_MISSING = "Please create the User before assigning any bug to it.";
    private static String INVALID_STATE_TRANSITION_OF_BUG = "Bug have a pre defined state transition, please follow it.";

    @ExceptionHandler(JpaObjectRetrievalFailureException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(JpaObjectRetrievalFailureException exception) {

        ErrorResponse errorResponse = ErrorResponseFactory
                .buildBadRequestInvalidUserResponse(USER_MISSING);

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    @ExceptionHandler(InvalidStateTransitionOfBug.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(InvalidStateTransitionOfBug invalidStateTransitionOfBug) {
        ErrorResponse errorResponse = ErrorResponseFactory
                .buildBadRequestInvalidStateTransition(INVALID_STATE_TRANSITION_OF_BUG);

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    private static ResponseEntity<ErrorResponse> buildBadRequestErrorResponseEntity(ErrorResponse errorResponse) {
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

