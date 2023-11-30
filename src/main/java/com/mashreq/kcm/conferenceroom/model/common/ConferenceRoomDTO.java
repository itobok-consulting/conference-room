package com.mashreq.kcm.conferenceroom.model.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mashreq.kcm.conferenceroom.enums.ConferenceRoomName;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
public class ConferenceRoomDTO {
    @JsonProperty("startDate")
    private String startTime;
    @JsonProperty("endDate")
    private String endTime;
    @JsonProperty("numberOfPersonsAllowed")
    private int numberOfPersonsAllowed;
    @JsonProperty("conferenceName")
    private ConferenceRoomName conferenceName;

}
