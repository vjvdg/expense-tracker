package com.vjvdg.expensetracker.util;

import org.springframework.stereotype.Component;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@Component
public class DateUtils {

    private DateUtils() {}

    public static ZonedDateTime getMonthStartDateTime(Integer year, Integer month) {
        return ZonedDateTime.of(year, month, 1, 0, 0, 0, 0, ZoneId.of("Asia/Singapore"));
    }

    public static ZonedDateTime getMonthEndDateTime(Integer year, Integer month) {
        return ZonedDateTime.of(year, month + 1, 1, 23, 59, 59, 999999999, ZoneId.of("Asia/Singapore")).minusDays(1);
    }

}
