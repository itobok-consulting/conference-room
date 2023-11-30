package com.mashreq.kcm.conferenceroom.service.impl;

import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.repository.BookingRepository;
import com.mashreq.kcm.conferenceroom.service.BookingsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class BookingsServiceImpl implements BookingsService {
    private final BookingRepository bookingRepository;

    public BookingsServiceImpl(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }
    @Override
    public Bookings saveBookingDetails(Bookings bookingDetails) {
        return bookingRepository.save(bookingDetails);
    }
    public Optional<Bookings> isConferenceRoomBooked(String conferenceRoomName) {
        return bookingRepository.findByConferenceName(conferenceRoomName);
    }

    @Override
    public List<Bookings> listAvailableRooms(String startTime, String endTime) {
        return  bookingRepository.findByStartTimeAndEndTime(startTime, endTime);
    }
}
