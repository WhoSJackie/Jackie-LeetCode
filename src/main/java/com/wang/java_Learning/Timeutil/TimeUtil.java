package com.wang.java_Learning.Timeutil;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimeUtil {

    /**
     * 计算两日期相差天数
     * @param date1
     * @param date2
     * @throws ParseException
     */
    public static int dayDiff(String date1,String date2) throws ParseException {
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1=Calendar.getInstance();
        Calendar calendar2=Calendar.getInstance();
        Date tr1=format.parse(date1);
        Date tr2=format.parse(date2);
        calendar1.setTime(tr1);
        calendar2.setTime(tr2);
        System.out.println(tr1);
        System.out.println(tr2);

        //开始计算
        //获取两个日期的当年天数
        int day1=calendar1.get(Calendar.DAY_OF_YEAR);
        int day2=calendar2.get(Calendar.DAY_OF_YEAR);

        //获取两个日期的年份
        int year1=calendar1.get(Calendar.YEAR);
        int year2=calendar2.get(Calendar.YEAR);

        if(year1!=year2){
            int timesum=0;
            for(int i=year1;i<year2;i++){
                //为闰年
                if((i%4==0&&i%100!=0)||(i%400==0)){
                    timesum+=366;
                }
                else{
                    timesum+=365;
                }
            }

            return (Math.abs(day2-day1)+timesum);
        }
        else{
            return Math.abs(day2-day1);
        }

    }

    public static int dayDiff1(String date1,String date2) throws ParseException{
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar1=Calendar.getInstance();
        Calendar calendar2=Calendar.getInstance();
        Date tr1=format.parse(date1);
        Date tr2=format.parse(date2);
        calendar1.setTime(tr1);
        calendar2.setTime(tr2);
        System.out.println(tr1);
        System.out.println(tr2);

        //开始计算
        //获取两个日期的当年天数
        int day1=calendar1.get(Calendar.DAY_OF_YEAR);
        int day2=calendar2.get(Calendar.DAY_OF_YEAR);

        //获取两个日期的年份
        int year1=calendar1.get(Calendar.YEAR);
        int year2=calendar2.get(Calendar.YEAR);


        if(year1!=year2){
            Calendar cal=Calendar.getInstance();
            int timesum=0;
            for(int i=year1;i<year2;i++){
                cal.set(Calendar.YEAR,i);
                Calendar cal2=new GregorianCalendar(cal.get(Calendar.YEAR),11,31);
                timesum+=cal2.get(Calendar.DAY_OF_YEAR);
            }
            return (Math.abs(day2-day1)+timesum);
        }
        else{
            return Math.abs(day2-day1);
        }

    }

    //将某一时间戳转化为当天的0时0分
    public static void getStartTime(String time){
        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar=Calendar.getInstance();

        long ltime=Long.parseLong(time);
        Date date=new Date(ltime);
        calendar.setTime(date);
//        System.out.println("calendar1-->"+calendar);
        calendar.set(Calendar.HOUR_OF_DAY,0);
        calendar.set(Calendar.MINUTE,0);
        calendar.set(Calendar.SECOND,0);
        Date time1 = calendar.getTime();
        Timestamp startTime=Timestamp.valueOf(df.format(time1));

        System.out.println("date-->"+date);
//        System.out.println("calendar2-->"+calendar);
        System.out.println("startTime-->"+startTime);
        System.out.println(calendar.get(Calendar.YEAR));
        System.out.println(calendar.get(Calendar.MONTH)+1);
        System.out.println(calendar.get(Calendar.DATE));
        System.out.println(calendar.get(Calendar.ZONE_OFFSET));

    }



    public static void main(String[] args) {
        getStartTime("1632987932483");
    }


}
