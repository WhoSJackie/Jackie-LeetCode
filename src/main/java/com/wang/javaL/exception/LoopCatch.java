package com.wang.javaL.exception;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class LoopCatch {

    public void loopCatchTest(){
        int count=0;
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        for (Integer integer : list) {
            try{
                count+= new TestInstanceOf().testTryCatch(integer,count);
            } catch (Exception e){
                count++;
                System.out.println("捕获异常:"+e.getMessage());
            }
        }
        System.out.println("计数个数为: "+count);
    }

    public TimeRes getCurrentTime(){
        Calendar calendar = Calendar.getInstance();
        int curYear = calendar.get(Calendar.YEAR);
        int curMonth = calendar.get(Calendar.MONTH)+1;
        int curDate = calendar.get(Calendar.DATE);
        int curHour = calendar.get(Calendar.HOUR_OF_DAY);
        int curMinute = calendar.get(Calendar.MINUTE);
        TimeRes timeRes = new TimeRes(curYear,curMonth,curDate,curHour,curMinute,0);
        return timeRes;
    }

    public TimeRes getYesterdayTime(){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,-1);
        int yYear = calendar.get(Calendar.YEAR);
        int yMonth = calendar.get(Calendar.MONTH)+1;
        int yDate = calendar.get(Calendar.DATE);
        int yHour = calendar.get(Calendar.HOUR_OF_DAY);
        int yMinute = calendar.get(Calendar.MINUTE);
        TimeRes timeRes = new TimeRes(yYear,yMonth,yDate,yHour,yMinute,0);
        return timeRes;
    }

    public TimeRes getExactTime(String time) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(sdf.parse(time));
        int tarYear = calendar.get(Calendar.YEAR);
        int tarMonth = calendar.get(Calendar.MONTH)+1;
        int tarDate = calendar.get(Calendar.DATE);
        int tarHour = calendar.get(Calendar.HOUR_OF_DAY);
        int tarMinute = calendar.get(Calendar.MINUTE);
        TimeRes timeRes = new TimeRes(tarYear,tarMonth,tarDate,tarHour,tarMinute,0);
        return timeRes;
    }

    public boolean inExactTime(String time,int approval) throws ParseException {
        TimeRes cur = getCurrentTime();
        TimeRes tar = getExactTime(time);
        TimeRes y = getYesterdayTime();

        if (cur.getYear()==tar.getYear()){
            if (cur.getMonth()==tar.getMonth()){
                // 是同一月份
                if (cur.getDate() == tar.getDate()){
                    // 同一天，为当天15:00之前
                    if (tar.getHour()<approval){
                        return true;
                    }
                } else{
                    // 不同的日期,必须为昨天的审批日之后
                    if ((tar.getDate()==y.getDate())&&(tar.getHour()>=approval)){
                        return true;
                    }
                }
            } else{
                // 跨月
                if ((y.getMonth()==tar.getMonth())&&(y.getDate()==tar.getDate())&&(tar.getHour()>=approval)){
                    return true;
                }
            }
        } else{
            // 跨年
            if ((y.getYear()==tar.getYear())&&(y.getMonth()==tar.getMonth())&&(y.getDate()==tar.getDate())&&(tar.getHour()>=approval)){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ParseException {
        LoopCatch loopCatch = new LoopCatch();
        // loopCatch.inExactTime("2022-10-01 15:58:34",15);
        System.out.println(loopCatch.getExactTime("2022-01-01 15:00:00"));
    }

}
