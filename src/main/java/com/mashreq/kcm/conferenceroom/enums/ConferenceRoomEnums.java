package com.mashreq.kcm.conferenceroom.enums;

import lombok.Getter;

@Getter
public enum ConferenceRoomEnums {
    CONFERENCE_ROOM_REQUEST("conferenceRoomRequest", "conferenceRoomRequest is mandatory"),
    START_TIME("startTime", "Conference.startTime is mandatory"),
    END_TIME("endTime", "Conference.endTime is mandatory");

    private final String fieldName;
    private final String message;

    ConferenceRoomEnums(String fieldName, String message){
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }
}
