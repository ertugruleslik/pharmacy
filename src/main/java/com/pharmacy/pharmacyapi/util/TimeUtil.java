package com.pharmacy.pharmacyapi.util;

import org.springframework.util.ObjectUtils;

import java.util.Date;

public class TimeUtil {

    @SuppressWarnings("deprecation")
    public static boolean isOutOfWorkingHour(Long timestamp) {
        if (ObjectUtils.isEmpty(timestamp)) {
            timestamp = System.currentTimeMillis();
        }

        Date date = new Date(timestamp);

        int hours = date.getHours();

        if (hours > 8 && hours < 19) {
            return false;
        }

        return true;
    }

}
