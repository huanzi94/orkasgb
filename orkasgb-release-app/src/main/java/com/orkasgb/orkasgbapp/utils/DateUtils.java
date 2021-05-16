package com.orkasgb.orkasgbapp.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

    public static final String TIME_24FORMT_STRYING = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_12FORMT_STRYING = "yyyy-MM-dd hh:mm:ss";

    public static final String TIME_FORMT_STRYING = "yyyy-MM-dd";

    public static Long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String current24TimeString() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_24FORMT_STRYING);
        simpleDateFormat.format(date);
        return simpleDateFormat.format(date);
    }

    public static String current12TimeString() {
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TIME_12FORMT_STRYING);
        simpleDateFormat.format(date);
        return simpleDateFormat.format(date);
    }

}
