package com.wang.javaL.concurrentLearn.MultiThreadTest;

public class CircleRunnable implements Runnable {
    @Override
    public void run() {
        for (int i=0;i<100;i++){
            System.out.println("当前线程名："+Thread.currentThread().getName()+"，第i个值为:"+i);
        }
    }
}
