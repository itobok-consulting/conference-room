package com.mashreq.kcm.conferenceroom.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static com.mashreq.kcm.conferenceroom.constants.Constants.*;

public class DateUtil {

    public static boolean isValidDate(String passedDate) {
        try {
            if (dateFormatter(passedDate).after(new Date())) {
                return false;
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static long calculateTimeDifference(String start, String end) {
        try {
            Date parseStartDate = dateFormatter(start);
            Date parsedEndDate = dateFormatter(end);
            return parseStartDate.getTime() - parsedEndDate.getTime();
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public static Date dateFormatter(String date) throws ParseException {
        return new SimpleDateFormat(HOUR_PATTERN, Locale.ENGLISH).parse(date);
    }

    public static boolean isBookingAllowed(String bookingTime) {
        return checkBookingTime(bookingTime, BOOKING_START_TIME_ARRAY_LIST, BOOKING_END_TIME_ARRAY_LIST);
    }

    public static boolean maintenanceIntervals(String bookingTime) {
        return checkBookingTime(bookingTime, MAINTANENCE_START_TIME_ARRAY_LIST, MAINTANENCE_END_TIME_ARRAY_LIST);
    }

    private static boolean checkBookingTime(String bookingTime, List<String> stringStartTimeArrayList, List<String> stringEndTimeArrayList) {
        for (int i = 0; i < stringStartTimeArrayList.size(); i++) {
            LocalTime localTimeStart = convertToLocalTime(stringStartTimeArrayList.get(i));
            LocalTime localTimeEnd = convertToLocalTime(stringEndTimeArrayList.get(i));
            LocalTime checkingTime = convertToLocalTime(bookingTime);
            if (localTimeEnd.isAfter(localTimeStart)) {
                return localTimeStart.isBefore(checkingTime) && localTimeEnd.isAfter(checkingTime);
            }
        }
        return false;
    }


    private static LocalTime convertToLocalTime(String str) {
        return LocalTime.parse(str);
    }

}


