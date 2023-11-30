package com.mashreq.kcm.conferenceroom.service.impl;

import com.mashreq.kcm.conferenceroom.constants.Constants;
import com.mashreq.kcm.conferenceroom.enums.CapacityRange;
import com.mashreq.kcm.conferenceroom.exceptions.MeetingRoomException;
import com.mashreq.kcm.conferenceroom.exceptions.NoRoomBookedException;
import com.mashreq.kcm.conferenceroom.exceptions.ValidationException;
import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;
import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.service.BookingRoomUseCase;
import com.mashreq.kcm.conferenceroom.service.BookingsService;
import com.mashreq.kcm.conferenceroom.validations.ConferenceRoomValidator;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import com.mashreq.kcm.conferenceroom.model.common.mapper.BookingRoomMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.mashreq.kcm.conferenceroom.constants.Constants.MEETING_ROOM_ALREADY_BOOKED;
import static com.mashreq.kcm.conferenceroom.constants.Constants.NO_MEETING_ROOM_AVAILABLE;
import static com.mashreq.kcm.conferenceroom.model.common.mapper.BookingRoomMapper.mapBookingDetails;

@Slf4j
@Service
public class BookingRoomUseCaseImpl implements BookingRoomUseCase {
    private final ConferenceRoomValidator conferenceRoomValidator;
    private final BookingsService bookingsService;

    public BookingRoomUseCaseImpl(ConferenceRoomValidator conferenceRoomValidator, BookingsService bookingsService) {
        this.conferenceRoomValidator = conferenceRoomValidator;
        this.bookingsService = bookingsService;
    }

    @Override
    public Bookings bookMeetingRoom(BookingDTO bookingDTO) throws ValidationException {
        ConferenceRoomDTO conferenceRoomDTO = BookingRoomMapper.mapConferenceRoomDTO(bookingDTO);
        List<FieldValidationModel> errors = conferenceRoomValidator.inputValidator(conferenceRoomDTO);
        if (!errors.isEmpty()) { throw new ValidationException(errors); }

        return saveBookingDetails(conferenceRoomDTO);
    }

    @Override
    public List<Bookings> listConferenceRoom(String startTime, String endTime) throws NoRoomBookedException {
        List<Bookings> bookingsList = bookingsService.listAvailableRooms(startTime, endTime);
        if (bookingsList.isEmpty()) {
            throw new NoRoomBookedException(NO_MEETING_ROOM_AVAILABLE);
        }
        return bookingsList;
    }

    private Bookings saveBookingDetails(ConferenceRoomDTO conferenceRoomDTO){
        conferenceRoomDTO.setConferenceName(CapacityRange.setConferenceName(conferenceRoomDTO));

        Optional<Bookings> conferenceRoomBooked = bookingsService.isConferenceRoomBooked(conferenceRoomDTO.getConferenceName().toString());
        if (conferenceRoomBooked.isPresent()) {
            throw new MeetingRoomException(MEETING_ROOM_ALREADY_BOOKED, conferenceRoomDTO.getConferenceName().toString());
        }
        return bookingsService.saveBookingDetails(mapBookingDetails(conferenceRoomDTO));
    }
}
