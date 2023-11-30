package com.mashreq.kcm.conferenceroom.validations.argument;

import com.google.gson.Gson;
import com.mashreq.kcm.conferenceroom.model.common.FieldValidationModel;
import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ConferenceRoomArgument {
    private Gson jsonConverter;
    private ConferenceRoomDTO conferenceRoomRequest;
    private List<FieldValidationModel> fieldList;
}
