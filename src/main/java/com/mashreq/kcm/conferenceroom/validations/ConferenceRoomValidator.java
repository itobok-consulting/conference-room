package com.mashreq.kcm.conferenceroom.validations;

import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import com.mashreq.kcm.conferenceroom.validations.rules.ConferenceRoomValidationRule;
import com.mashreq.kcm.conferenceroom.validations.rules.RoomsAbstractValidator;
import com.mashreq.kcm.conferenceroom.validations.utils.ConferenceRoomInputUtil;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ConferenceRoomValidator {
    public List<FieldValidationModel> inputValidator(ConferenceRoomDTO conferenceRoomDTO) {
        ConferenceRoomArgument argument = ConferenceRoomInputUtil.getConferenceRoomArgument(conferenceRoomDTO);
        RoomsAbstractValidator<ConferenceRoomArgument> inputValidation = new ConferenceRoomValidationRule();
        inputValidation.validate(argument);
        return argument.getFieldList();
    }
}
