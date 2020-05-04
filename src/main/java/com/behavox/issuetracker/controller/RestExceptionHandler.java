package com.behavox.issuetracker.controller;

import com.behavox.issuetracker.exception.ErrorResponse;
import com.behavox.issuetracker.exception.ErrorResponseFactory;
import com.behavox.issuetracker.exception.InvalidStateTransitionOfBug;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.persistence.EntityNotFoundException;
import javax.ws.rs.BadRequestException;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static String USER_MISSING = "Please create the User before assigning any bug to it.";
    private static String INVALID_STATE_TRANSITION_OF_BUG = "Bug have a pre defined state transition, please follow it.";
    private static String MISSING_ENTITY = "Unable to find the records in database";

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

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(EntityNotFoundException e) {

        ErrorResponse errorResponse = ErrorResponseFactory
                .buildEntityNotFoundException(MISSING_ENTITY);

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(ConstraintViolationException constraintViolationException) {
        ErrorResponse errorResponse = ErrorResponseFactory
                .buildForgienKeyConstraintException(constraintViolationException.getMessage());

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    @ExceptionHandler(HttpServerErrorException.InternalServerError.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(HttpServerErrorException.InternalServerError internalServerError) {
        ErrorResponse errorResponse = ErrorResponseFactory
                .buildInternalServerError(internalServerError.getMessage());

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(BadRequestException badRequestException) {

        ErrorResponse errorResponse = ErrorResponseFactory
                .buildBadRequestException(badRequestException.getMessage());

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception e) {

        ErrorResponse errorResponse = ErrorResponseFactory
                .buildInternalServerError(e.getMessage());

        return buildBadRequestErrorResponseEntity(errorResponse);
    }

    private static ResponseEntity<ErrorResponse> buildBadRequestErrorResponseEntity(ErrorResponse errorResponse) {
        return ResponseEntity.badRequest().body(errorResponse);
    }
}

