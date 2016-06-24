package com.tylerhyperhd.profreedommod.utils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class TimeSelector {

    public static String getTime() {
        return ZonedDateTime.now().format(DateTimeFormatter.RFC_1123_DATE_TIME);
    }
}