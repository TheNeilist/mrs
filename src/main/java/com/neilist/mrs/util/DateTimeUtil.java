package com.neilist.mrs.util;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class DateTimeUtil {

    public static int minuteOfDay(LocalDateTime date) {
        return date.get(ChronoField.MINUTE_OF_DAY);
    }

    public static int minuteOfDay(LocalTime time) {
        return time.get(ChronoField.MINUTE_OF_DAY);
    }

    public static int dayOfWeek(LocalDateTime date) {
        return date.getDayOfWeek().getValue();
    }

}
