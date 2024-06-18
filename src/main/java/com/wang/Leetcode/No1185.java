package com.wang.Leetcode;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class No1185 {
    String[] week = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    public String dayOfWeek(int day,int month,int year){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String str = year+"-"+month+"-"+((day>=1&&day<=9)?("0"+day):day);
        Date date = null;
        try {
            date = sdf.parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return week[calendar.get(Calendar.DAY_OF_WEEK)-1];
    }

    public static void main(String[] args) {
        System.out.println(new No1185().dayOfWeek(6, 1, 2024));
    }

}
