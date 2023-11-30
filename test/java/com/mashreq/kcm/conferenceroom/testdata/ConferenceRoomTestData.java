package com.mashreq.kcm.conferenceroom.testdata;

import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;

import java.util.Date;

import static com.mashreq.kcm.conferenceroom.enums.ConferenceRoomName.Amaze;
import static com.mashreq.kcm.conferenceroom.enums.ConferenceRoomName.Beauty;

public class ConferenceRoomTestData {
    public static Bookings getBookingData() {
        return Bookings.builder()
                .conferenceName(Amaze.name())
                .startTime("02:01")
                .endTime("02:13")
                .build();
    }

    public static BookingDTO getBookingDTO() {
        return BookingDTO.builder()
                .startTime("02:01")
                .endTime("02:13")
                .numberOfPeopleAttending(5)
                .conferenceName(Beauty.name())
                .build();

    }x
}
