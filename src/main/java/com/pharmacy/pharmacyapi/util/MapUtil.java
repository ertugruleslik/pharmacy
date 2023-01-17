package com.pharmacy.pharmacyapi.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class MapUtil {

    public static Double getLongitude(String map) {
        String longitude = map.split(",")[0];
        return Double.parseDouble(longitude);
    }

    public static Double getLatitude(String map) {
        String latitude = map.split(",")[1];
        return Double.parseDouble(latitude);
    }
}
