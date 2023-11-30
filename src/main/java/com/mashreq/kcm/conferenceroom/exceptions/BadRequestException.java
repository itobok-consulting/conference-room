package com.mashreq.kcm.conferenceroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The type Bad request exception.
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid Data Provided")
public class BadRequestException extends RuntimeException {
    /**
     * Instantiates a new Bad request exception.
     *
     * @param message the message
     */
    public BadRequestException(final String message) {
        super(message);
    }
}
