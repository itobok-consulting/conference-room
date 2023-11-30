package com.mashreq.kcm.conferenceroom.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Conference room not found")
public class NoRoomBookedException extends RuntimeException{

    /**
     * Instantiates no meeting room booked
     *
     * @param message the message
     */

    public NoRoomBookedException(String message) {
        super(message);
    }

}
