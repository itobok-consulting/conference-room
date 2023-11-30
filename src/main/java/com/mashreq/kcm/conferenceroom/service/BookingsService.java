package com.mashreq.kcm.conferenceroom.service;

import com.mashreq.kcm.conferenceroom.model.Bookings;

import java.util.List;
import java.util.Optional;

public interface BookingsService {
    Bookings saveBookingDetails(Bookings bookingDetails);
    Optional<Bookings> isConferenceRoomBooked(String bookings);
    List<Bookings> listAvailableRooms(String startTime, String endTime);
}
