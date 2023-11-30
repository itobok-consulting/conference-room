package com.mashreq.kcm.conferenceroom.validations.utils;

import com.mashreq.kcm.conferenceroom.model.common.BookingDTO;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.utils.DateUtil;
import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Objects;

import static com.mashreq.kcm.conferenceroom.enums.BookingInputEnums.*;
import static com.mashreq.kcm.conferenceroom.enums.ConferenceRoomEnums.CONFERENCE_ROOM_REQUEST;
import static com.mashreq.kcm.conferenceroom.utils.DateUtil.calculateTimeDifference;
import static com.mashreq.kcm.conferenceroom.validations.utils.ValidationUtil.setFieldValidationObject;
import static com.mashreq.kcm.conferenceroom.validations.utils.ValidationUtil.setInputValidationObject;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RoomInputValidationUtil {
    public static void validateRoomInput(List<FieldValidationModel> fieldList, ConferenceRoomDTO roomArgument) {
        if (Objects.isNull(roomArgument)) {
            setFieldValidationObject(fieldList, CONFERENCE_ROOM_REQUEST.getFieldName(), CONFERENCE_ROOM_REQUEST.getMessage());
        }
        if (!DateUtil.isValidDate(roomArgument.getStartTime())) {
            setFieldValidationObject(fieldList, BOOKING_DATE_SHOULD_BE_CURRENT_DATE.getFieldName(), BOOKING_DATE_SHOULD_BE_CURRENT_DATE.getMessage());
        }
    }

    public static void validateTimeInterval(List<FieldValidationModel> fieldList, ConferenceRoomDTO conferenceRoomDTO) {
        long timeDifference = calculateTimeDifference(conferenceRoomDTO.getStartTime(), conferenceRoomDTO.getEndTime());
        long minutesDifference = (timeDifference / (1000 * 60))  % 60;
        if (minutesDifference >= 15) {
            setFieldValidationObject(fieldList, BOOKING_DATE_SHOULD_BE_CURRENT_DATE.getFieldName(), BOOKING_DATE_SHOULD_BE_CURRENT_DATE.getMessage());
        }
    }

    public static void validateBookingIntervals(List<FieldValidationModel> fieldList, ConferenceRoomArgument roomArgument){
        BookingDTO bookingDTO = BookingDTO.builder()
                .startTime(roomArgument.getConferenceRoomRequest().getStartTime())
                .endTime(roomArgument.getConferenceRoomRequest().getEndTime())
                .build();
        if (Objects.nonNull(bookingDTO)) {
            if(!DateUtil.isBookingAllowed(bookingDTO.getStartTime())) {
                setInputValidationObject(fieldList, START_TIME_NOT_ALLOWED.getMessage());
            }
            if(DateUtil.maintenanceIntervals(bookingDTO.getStartTime())) {
                setInputValidationObject(fieldList, BOOKING_NOT_ALLOWED_WRONG_MAINTENANCE.getMessage());
            }
        }
    }
}
