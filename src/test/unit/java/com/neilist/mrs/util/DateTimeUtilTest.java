package com.neilist.mrs.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class DateTimeUtilTest {

    @Test
    public void testMinuteOfDayTime() throws Exception {
        assertEquals(0, DateTimeUtil.minuteOfDay(timeMe(0,0)));
        assertEquals(1, DateTimeUtil.minuteOfDay(timeMe(0,1)));
        assertEquals(720, DateTimeUtil.minuteOfDay(timeMe(12,00)));
        assertEquals(1439, DateTimeUtil.minuteOfDay(timeMe(23,59)));
    }

    @Test
    public void testMinuteOfDayDate() throws Exception {
        assertEquals(0, DateTimeUtil.minuteOfDay(dateMe(1979, 7, 15,0,0)));
        assertEquals(1, DateTimeUtil.minuteOfDay(dateMe(1979, 7, 15,0,1)));
        assertEquals(720, DateTimeUtil.minuteOfDay(dateMe(1979, 7, 15,12,00)));
        assertEquals(1439, DateTimeUtil.minuteOfDay(dateMe(1979, 7, 15,23,59)));
    }

    @Test
    public void testDayOfWeek() throws Exception {
        assertEquals(1, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 22,0, 0)));
        assertEquals(1, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 22,0, 1)));
        assertEquals(1, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 22,23, 59)));

        assertEquals(7, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 21,0, 0)));
        assertEquals(7, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 21,0, 1)));
        assertEquals(7, DateTimeUtil.dayOfWeek(dateMe(2018, 1, 21,23, 59)));
    }

    private LocalDateTime dateMe(int year, int month, int day, int hour, int minute) {
        return LocalDateTime.of(LocalDate.of(year, month, day), timeMe(hour, minute));
    }

    private LocalTime timeMe(int hour, int minute) {
        return LocalTime.of(hour, minute);
    }
}
