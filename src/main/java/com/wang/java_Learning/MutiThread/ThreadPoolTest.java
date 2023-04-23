package com.wang.java_Learning.MutiThread;

import java.util.Random;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

    public void ThreadPoolExecutorTest() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 16, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 10; i++) {
            ThreadLocalTest localTest = new ThreadLocalTest();
            executor.execute(localTest);
            Thread.sleep(new Random().nextInt(1000));
        }
        executor.shutdown();
    }

    public static void main(String[] args) throws InterruptedException {
        new ThreadPoolTest().ThreadPoolExecutorTest();
    }

}
