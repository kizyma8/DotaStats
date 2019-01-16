package com.stats.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Utils {
    private static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd", Locale.US);

    public static Long convertStringDateToTime(String date) {
        try {
            return (DATE_FORMAT.parse(date).getTime()/1000);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }
}
