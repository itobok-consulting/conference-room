package com.mashreq.kcm.conferenceroom.service.impl;

import com.mashreq.kcm.conferenceroom.exceptions.MeetingRoomException;
import com.mashreq.kcm.conferenceroom.exceptions.NoRoomBookedException;
import com.mashreq.kcm.conferenceroom.model.Bookings;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.model.common.mapper.BookingRoomMapper;
import com.mashreq.kcm.conferenceroom.service.BookingsService;
import com.mashreq.kcm.conferenceroom.testdata.ConferenceRoomTestData;
import com.mashreq.kcm.conferenceroom.validations.ConferenceRoomValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.mashreq.kcm.conferenceroom.constants.Constants.NO_MEETING_ROOM_AVAILABLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(MockitoExtension.class)
class BookingRoomUseCaseImplTest {

    @InjectMocks
    private BookingRoomUseCaseImpl bookingRoomUseCase;
    @Mock
    private ConferenceRoomValidator conferenceRoomValidator;
    @Mock
    private BookingsService bookingsService;

    @Test
    void bookMeetingRoom() throws MeetingRoomException {
        Bookings bookings = bookingRoomUseCase.bookMeetingRoom(ConferenceRoomTestData.getBookingDTO());
        assertNull(bookings);
        ConferenceRoomDTO conferenceRoomDTO = BookingRoomMapper.mapConferenceRoomDTO(ConferenceRoomTestData.getBookingDTO());
        List<FieldValidationModel> errorList = conferenceRoomValidator.inputValidator(conferenceRoomDTO);
        assertEquals(0, errorList.size());
    }

    @Test
    void listConferenceRoom() throws NoRoomBookedException {
        Assertions.assertThrows(NoRoomBookedException.class,
                () -> bookingRoomUseCase.listConferenceRoom("02:01", "02:12"), NO_MEETING_ROOM_AVAILABLE);
    }
}

