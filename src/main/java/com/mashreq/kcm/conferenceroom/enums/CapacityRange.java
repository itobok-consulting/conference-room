package com.mashreq.kcm.conferenceroom.enums;

import com.mashreq.kcm.conferenceroom.model.common.ConferenceRoomDTO;

import java.util.Arrays;


public enum CapacityRange {
    AMAZE(1,3),
    BEAUTY(3,7),
    INSPIRE(7,12),
    STRIVE(12,20),
    DEFAULT(-1, -1);

    private final int min;
    private final int max;

    CapacityRange(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public static CapacityRange from(int interval) {
        return Arrays.stream(CapacityRange.values())
                .filter(range -> interval >= range.min && interval <= range.max)
                .findAny()
                .orElse(DEFAULT);
    }

    public static ConferenceRoomName setConferenceName(final ConferenceRoomDTO conferenceRoomDTO) {
        switch (CapacityRange.from(conferenceRoomDTO.getNumberOfPersonsAllowed())) {
            case AMAZE -> {
                return ConferenceRoomName.Amaze;
            }
            case BEAUTY -> {
                return ConferenceRoomName.Beauty;
            }
            case INSPIRE -> {
                return ConferenceRoomName.Inspire ;
            }
            case STRIVE -> {
                return ConferenceRoomName.Strive;
            }
        }
        return ConferenceRoomName.Amaze;
    }
}
