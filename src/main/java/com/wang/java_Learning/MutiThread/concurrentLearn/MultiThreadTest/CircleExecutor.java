package com.wang.java_Learning.MutiThread.concurrentLearn.MultiThreadTest;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CircleExecutor {


    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            threadPool.submit(new CircleRunnable());
        }
        threadPool.shutdown();
        try{
            if (!threadPool.awaitTermination(800, TimeUnit.MILLISECONDS)){
                threadPool.shutdownNow();
            }
        } catch(Exception e){
            threadPool.shutdownNow();
        }
//        for (int i=0;i<10;i++){
//            Thread thread = new Thread(new CircleRunnable());
//            thread.start();
//        }
    }
}
