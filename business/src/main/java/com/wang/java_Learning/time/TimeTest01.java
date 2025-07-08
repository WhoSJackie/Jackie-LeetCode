package com.wang.java_Learning.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeTest01 {

    /**
     * 判段当前时间是否早于15:00
     * @return
     */
    public static boolean isTimeBefore(){
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String date2 = simpleDateFormat.format(date)+" 15:00:00";
        simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date parse = null;
        try {
            parse = simpleDateFormat.parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date.before(parse);
    }

    public static void main(String[] args) {
        isTimeBefore();
    }

}
