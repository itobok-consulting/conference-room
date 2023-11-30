package com.mashreq.kcm.conferenceroom.controller;

import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;
import com.mashreq.kcm.conferenceroom.service.BookingRoomUseCase;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.text.ParseException;
import java.util.List;

@RestController
public class BookingRoomController {
    private final BookingRoomUseCase bookingRoomService;

    public BookingRoomController(BookingRoomUseCase bookingRoomService) {
        this.bookingRoomService = bookingRoomService;
    }

    @PostMapping(path = "/book-conference-room", produces = "application/json")
    public Bookings bookMeetingRoom(@RequestBody BookingDTO bookingDTO) throws ParseException {
        return bookingRoomService.bookMeetingRoom(bookingDTO);
    }

    @GetMapping(path = "{startTime}/list-rooms/{endTime}", produces = "application/json")
    public List<Bookings> listConferenceRoom(@PathVariable String startTime, @PathVariable String endTime) {
        return bookingRoomService.listConferenceRoom(startTime, endTime);
    }
}
