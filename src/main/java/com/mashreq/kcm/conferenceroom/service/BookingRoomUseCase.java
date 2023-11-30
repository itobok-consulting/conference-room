package com.mashreq.kcm.conferenceroom.service;

import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;
import com.mashreq.kcm.conferenceroom.exceptions.NoRoomBookedException;
import com.mashreq.kcm.conferenceroom.exceptions.ValidationException;

import java.text.ParseException;
import java.util.List;

public interface BookingRoomUseCase {
    Bookings bookMeetingRoom(BookingDTO bookingDTO) throws ValidationException, ParseException;
    List<Bookings> listConferenceRoom(String startTime, String endTime) throws NoRoomBookedException;
}
