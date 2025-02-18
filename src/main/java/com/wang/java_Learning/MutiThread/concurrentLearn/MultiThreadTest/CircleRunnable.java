package com.wang.java_Learning.MutiThread.concurrentLearn.MultiThreadTest;

public class CircleRunnable implements Runnable {
    private String name;
    public CircleRunnable(String name){
        this.name = name;
    }
    @Override
    public void run() {

        for (int i=0;i<100;i++){
            System.out.println("当前线程名："+name+"，第i个值为:"+i);
        }
    }
}
