package com.vjvdg.expensetracker.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class DateUtils {

    private DateUtils() {}

    public static ZonedDateTime getMonthStartDateTime(Integer year, Integer month) {
        LocalDateTime localDateTimeStart = LocalDateTime.of(year, month, 1, 0, 0, 0);
        return ZonedDateTime.of(localDateTimeStart, ZoneId.of("Asia/Singapore"));
    }

    public static ZonedDateTime getMonthEndDateTime(Integer year, Integer month) {
        LocalDateTime localDateTimeEnd = LocalDateTime.of(year, month + 1, 1, 23, 59, 59).minusDays(1);
        return ZonedDateTime.of(localDateTimeEnd, ZoneId.of("Asia/Singapore"));
    }

}
