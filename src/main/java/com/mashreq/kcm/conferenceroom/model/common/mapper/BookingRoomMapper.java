package com.mashreq.kcm.conferenceroom.model.common.mapper;


import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BookingRoomMapper {
    public static ConferenceRoomDTO mapConferenceRoomDTO(BookingDTO bookingDTO) {
        return ConferenceRoomDTO.builder()
                .startTime(bookingDTO.getStartTime())
                .endTime(bookingDTO.getEndTime())
                .numberOfPersonsAllowed(bookingDTO.getNumberOfPeopleAttending())
                .build();
    }

    public static Bookings mapBookingDetails(ConferenceRoomDTO conferenceRoomDTO) {
        Bookings booking = new Bookings();
        booking.setCreatedDate(new Date());
        booking.setStartTime(conferenceRoomDTO.getStartTime());
        booking.setEndTime(conferenceRoomDTO.getEndTime());
        booking.setConferenceName(conferenceRoomDTO.getConferenceName().toString());
        return booking;
    }



}
