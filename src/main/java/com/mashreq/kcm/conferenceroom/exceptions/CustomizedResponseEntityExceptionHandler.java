package com.mashreq.kcm.conferenceroom.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ExceptionDetails> handleBadRequestException(
            BadRequestException ex,
            final HttpServletRequest request) {
        log.warn("Bad Request Exception:", ex);
        ExceptionDetails  exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.PRECONDITION_REQUIRED)
                .message(ex.getLocalizedMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(
                exceptionDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MeetingRoomException.class)
    public final ResponseEntity<ExceptionDetails> handleBadRequestException(
            MeetingRoomException ex,
            final HttpServletRequest request) {
        log.warn("Meeting Room Already Booked :", ex);
        ExceptionDetails  exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.CONFLICT)
                .message(ex.getLocalizedMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(
                exceptionDetails, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NoRoomBookedException.class)
    public final ResponseEntity<ExceptionDetails> handleBadRequestException(
            NoRoomBookedException ex,
            final HttpServletRequest request) {
        log.warn("No Conference Room Found:", ex);
        ExceptionDetails  exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.NOT_FOUND)
                .message(ex.getLocalizedMessage())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(
                exceptionDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public final ResponseEntity<ExceptionDetails> handleFieldValidationExceptions(
            final ValidationException ex,
            final HttpServletRequest request) {
        log.warn("Field Validation Exception:", ex);
        ExceptionDetails  exceptionDetails = ExceptionDetails.builder()
                .status(HttpStatus.PRECONDITION_REQUIRED)
                .fieldValidationErrors(ex.getValidationErrors())
                .path(request.getRequestURI())
                .build();

        return new ResponseEntity<>(
                exceptionDetails, HttpStatus.PRECONDITION_REQUIRED);
    }

}
