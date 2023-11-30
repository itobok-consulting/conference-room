package com.mashreq.kcm.conferenceroom.enums;

import lombok.Getter;

@Getter
public enum BookingInputEnums {
    START_TIME_NOT_ALLOWED("startTime", "Booking not allowed on the specific time"),
    BOOKING_NOT_ALLOWED_WRONG_MAINTENANCE("startTime", "Booking not allowed during maintenance"),
    BOOKING_DATE_SHOULD_BE_CURRENT_DATE( "startTime","Booking should be current date");
    private final String fieldName;
    private final String message;
    BookingInputEnums(String fieldName, String message ) {
        this.fieldName = fieldName;
        this.message = message;
    }
}
