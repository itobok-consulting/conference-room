package com.mashreq.kcm.conferenceroom.validations;

import org.junit.jupiter.api.Test;

import static com.mashreq.kcm.conferenceroom.utils.DateUtil.isBookingAllowed;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BookingRoomValidatorTest {

    @Test
    void validateBookingDetails() {
    }
    @Test
    public void validateBookingIntervals(){
        String timeGiven = "02:01";
        isBookingAllowed(timeGiven);
        assertTrue(isBookingAllowed(timeGiven));
    }

}
