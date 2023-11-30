package com.mashreq.kcm.conferenceroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.OK, reason = "Conference room already booked")
public class MeetingRoomException extends RuntimeException{

    /**
     * Instantiates a new Meeting room already booked exception.
     *
     * @param message the message
     */

    private String fieldName;

    public MeetingRoomException(final String message, String fieldName) {
        super(message);
        this.fieldName = fieldName;
    }
}
