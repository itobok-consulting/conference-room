package com.mashreq.kcm.conferenceroom.validations.rules;

import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import com.mashreq.kcm.conferenceroom.validations.utils.RoomInputValidationUtil;

import java.util.Objects;

public class BookingRoomValidationRule extends RoomsAbstractValidator<ConferenceRoomArgument> {
    private boolean setNextValidator = true;

    @Override
    public void validate(ConferenceRoomArgument argument) {
        if (Objects.nonNull(argument)) {
            if (Objects.nonNull(argument.getConferenceRoomRequest())) {
                RoomInputValidationUtil.validateTimeInterval(argument.getFieldList(), argument.getConferenceRoomRequest());
                RoomInputValidationUtil.validateRoomInput(argument.getFieldList(), argument.getConferenceRoomRequest());
                RoomInputValidationUtil.validateBookingIntervals(argument.getFieldList(), argument);
            }
            this.setNextValidator = false;
        }
        super.validate(argument);
    }
    @Override
    public void setNextValidator() {
        if (this.setNextValidator) {
            this.setNextValidator(new ConferenceRoomValidationRule());
        }
    }
}
