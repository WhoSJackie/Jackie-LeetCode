package com.wang.java_Learning.MutiThread.concurrentLearn.MultiThreadTest;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircleExecutor {


    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        threadPool.submit(new CircleRunnable("小A"));
        threadPool.submit(new CircleRunnable("小B"));
        threadPool.shutdown();
        try{
            if (!threadPool.awaitTermination(1, TimeUnit.MILLISECONDS)){
                threadPool.shutdownNow();
            } else{
                System.out.println("所有线程执行完毕!");
            }
        } catch(Exception e){
            threadPool.shutdownNow();
        }
        // 普通创建方式
//        for (int i=0;i<10;i++){
//            Thread thread = new Thread(new CircleRunnable());
//            thread.start();
//        }
    }
}
