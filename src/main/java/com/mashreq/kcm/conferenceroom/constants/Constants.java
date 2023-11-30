package com.mashreq.kcm.conferenceroom.constants;

import java.util.List;

import static java.util.Arrays.asList;

public interface Constants {
    String HOUR_PATTERN = "HH:mm";
    String NO_MEETING_ROOM_AVAILABLE = "There are not rooms available for the specific time range.";
    String MEETING_ROOM_ALREADY_BOOKED  = "Meeting room already booked.";
    List<String> BOOKING_START_TIME_ARRAY_LIST = asList("02:00", "02:00", "02:00");
    List<String> BOOKING_END_TIME_ARRAY_LIST = asList("02:15", "02:30", "03:00");
    List<String> MAINTANENCE_START_TIME_ARRAY_LIST = asList("09:00", "13:00", "17:00");
    List<String> MAINTANENCE_END_TIME_ARRAY_LIST = asList("09:15", "13:15", "17:15");


}


