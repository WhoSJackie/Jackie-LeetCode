package com.wang.java_Learning.hutool;

import cn.hutool.core.date.StopWatch;

public class ProcessTime {

    public static void main(String[] args) {
        StopWatch stopwatch = new StopWatch("任务1");
        try {
            stopwatch.start("任务1");
            Thread.sleep(2000);
            stopwatch.stop();
            System.out.println("消耗时间->"+stopwatch.getLastTaskTimeMillis()/1000+"S");
            System.out.println(stopwatch.prettyPrint());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
