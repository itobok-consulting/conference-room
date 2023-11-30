package com.mashreq.kcm.conferenceroom.validations.rules;

import com.mashreq.kcm.conferenceroom.enums.ConferenceRoomEnums;
import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import com.mashreq.kcm.conferenceroom.validations.utils.ValidationUtil;

import java.util.Objects;

public class ConferenceRoomValidationRule extends RoomsAbstractValidator<ConferenceRoomArgument> {

    @Override
    public void validate(ConferenceRoomArgument argument) {
        if (Objects.isNull(argument.getConferenceRoomRequest())) {
            ValidationUtil.setFieldValidationObject(argument.getFieldList(), ConferenceRoomEnums.CONFERENCE_ROOM_REQUEST.getFieldName(), ConferenceRoomEnums.CONFERENCE_ROOM_REQUEST.getMessage());
        }
        super.validate(argument);
    }
    @Override
    public void setNextValidator() {
        this.setNextValidator(new BookingRoomValidationRule());
    }
}