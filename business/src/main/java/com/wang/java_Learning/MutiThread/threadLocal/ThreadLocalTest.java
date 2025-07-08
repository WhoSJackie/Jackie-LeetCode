package com.wang.java_Learning.MutiThread.threadLocal;

import com.wang.common.utils.StringUtils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ThreadLocalTest {

    private static final String dataPattern="yyyy-MM-dd";
    //SimpleDateFormat线程不安全的，当线程共享的时候，会引发异常
    private static ThreadLocal<SimpleDateFormat> simpleDateFormatThreadLocal=ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy年M月d日"));
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

    public void getStartDateAndEndDate(Map<String,Object> res,String[] arr){
        String startDate="",endDate="";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年M月d日");
        try{
            Calendar cal = Calendar.getInstance();
            for (String s : res.keySet()) {
                if (StringUtils.isEmpty(startDate)){
                    startDate = s;
                } else{
                    long time = sdf.parse(cal.get(Calendar.YEAR)+"年"+startDate).getTime();
                    long time1 = sdf.parse(cal.get(Calendar.YEAR)+"年"+s).getTime();
                    if (time1<time) startDate = s;
                }
                if (StringUtils.isEmpty(endDate)){
                    endDate = s;
                } else{
                    long time = sdf.parse(cal.get(Calendar.YEAR)+"年"+endDate).getTime();
                    long time1 = sdf.parse(cal.get(Calendar.YEAR)+"年"+s).getTime();
                    if (time1>time) endDate = s;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        arr[0] = startDate;
        arr[1] = endDate;
    }

    public static void main(String[] args) throws ParseException {
        Scanner in = new Scanner(System.in);
//        System.out.println("请输入第一行：");
        String str = in.nextLine();
//        System.out.println(str);
//        System.out.println("请输入：");
//        str = in.nextLine();
        while (!"exit".equals(str)){
            System.out.println("请输入：");
            str = in.nextLine();
            if ("exit".equals(str)) break;
            System.out.println(str);
        }
    }


}
