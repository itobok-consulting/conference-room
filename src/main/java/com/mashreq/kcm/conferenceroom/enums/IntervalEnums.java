package com.mashreq.kcm.conferenceroom.enums;

import lombok.Getter;

@Getter
public enum IntervalEnums {
    BOOKING_DATE_SHOULD_BE_CURRENT_DATE( "Booking should be current date"),
    BOOKING_INTERVAL_INVALID("Booking interval should be 15 minutes in between");
    private final String message;

    IntervalEnums(String message ) {
        this.message = message;
    }
}
