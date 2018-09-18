package com.pinnuli.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: pinnuli
 * @date: 2018-09-18
 */

public class DateTimeUtil {
    public static final SimpleDateFormat timestampFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    public static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");

    public static final SimpleDateFormat timeFormater = new SimpleDateFormat("hh:mm:ss");


    public static Date newDate(){
        return new Date();
    }

    /**
     * yyyy-MM-dd hh:mm:ss
     * @param date
     * @return
     */
    public static String getTimestamp(Date date){
        return timestampFormater.format(date);
    }

    /**
     * yyyy-MM-dd
     * @param date
     * @return
     */
    public static String getDate(Date date){
        return dateFormater.format(date);
    }

    /**
     * hh:mm:ss
     * @param date
     * @return
     */
    public static String getTime(Date date){
        return timeFormater.format(date);
    }
}
