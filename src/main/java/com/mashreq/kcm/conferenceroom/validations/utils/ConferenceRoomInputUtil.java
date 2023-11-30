package com.mashreq.kcm.conferenceroom.validations.utils;

import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.validations.argument.ConferenceRoomArgument;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;

import java.util.ArrayList;
import java.util.List;

public class ConferenceRoomInputUtil {
    public static ConferenceRoomArgument getConferenceRoomArgument(ConferenceRoomDTO conferenceRoomDTO) {
        List<FieldValidationModel> fieldList = new ArrayList<>();
        ConferenceRoomArgument roomArgument = new ConferenceRoomArgument();
        roomArgument.setConferenceRoomRequest(conferenceRoomDTO);
        roomArgument.setFieldList(fieldList);
        return roomArgument;
    }
}
