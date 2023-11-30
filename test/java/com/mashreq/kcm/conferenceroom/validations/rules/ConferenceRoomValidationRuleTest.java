package com.mashreq.kcm.conferenceroom.validations.rules;

import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import com.mashreq.kcm.conferenceroom.validations.utils.ConferenceRoomInputUtil;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ConferenceRoomValidationRuleTest {

    @Test
    void createConferenceRoom_success() {
        ConferenceRoomDTO conferenceRoomDetails = ConferenceRoomDTO.builder()
                .startTime("02:03")
                .endTime("02:14")
                .numberOfPersonsAllowed(13)
                .build();

        ConferenceRoomArgument conferenceRoomArgument = ConferenceRoomInputUtil.getConferenceRoomArgument(conferenceRoomDetails);
        ConferenceRoomValidationRule validationRule = new ConferenceRoomValidationRule();
        validationRule.validate(conferenceRoomArgument);
        Assertions.assertTrue(conferenceRoomArgument.getFieldList().isEmpty());

    }
}
