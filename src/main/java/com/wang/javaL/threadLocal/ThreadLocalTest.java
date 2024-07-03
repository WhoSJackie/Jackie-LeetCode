package com.wang.javaL.threadLocal;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

public class ThreadLocalTest {

    private static final String dataPattern="yyyy-MM-dd";
    //SimpleDateFormat线程不安全的，当线程共享的时候，会引发异常
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal=new ThreadLocal<>();
    private static final Long one_day_millions=24*60*60*1000L;

    public static Set<Timestamp> timeTest(Date strategyStartTime, Date strategyEndTime){
        Long start=strategyStartTime.getTime();
        Long end=strategyEndTime.getTime();

        Long count=start;

        Set<Timestamp> set=new TreeSet<>();
        while(count<end){
            set.add(new Timestamp(count));
            count+=one_day_millions;
        }

        return set;

    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date start=new Date(23456L);
        System.out.println(sdf.format(start));
        Date end=new Date();
        System.out.println(sdf.format(end));
        Set<Timestamp> set=timeTest(start,end);
        for (Timestamp timestamp : set) {
            System.out.println(sdf.format(timestamp));
        }
    }


}
