package com.platzi.javatest.util;

public class DateUtil {
    public static boolean SiesBiesiento (int year){
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}
