package com.wang.java_Learning.Timeutil;

import java.sql.Timestamp;
import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws ParseException {
        int i = TimeUtil.dayDiff("2019-8-23", "2021-9-2");
        int j=TimeUtil.dayDiff1("2019-8-23", "2021-9-2");
        System.out.println("相差天数(计算方式1)"+i+"相差天数(计算方式2)"+j);


        Timestamp a=Timestamp.valueOf("2021-10-10 15:00:00");
        Timestamp b=Timestamp.valueOf("2021-10-11 15:00:00");

        Timestamp x=a.before(b)?a:b;
        System.out.println(x);

    }
}
