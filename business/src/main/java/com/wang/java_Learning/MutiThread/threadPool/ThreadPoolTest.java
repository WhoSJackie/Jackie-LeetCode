package com.wang.java_Learning.MutiThread.threadPool;

import com.wang.java_Learning.MutiThread.VolatilAtomicRunnable;
import com.wang.java_Learning.MutiThread.VolatilReentrantlockRunnable;
import com.wang.java_Learning.MutiThread.VolatilSynchronizedRunnable;

import java.util.Scanner;
import java.util.concurrent.*;

public class ThreadPoolTest {



    public static void ThreadPoolExecutorTest() throws InterruptedException {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(8, 16, 1000, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(),new CustomRejectPolicy() );
        // 由于这里类的内部成员变量是普通变量，而这里都是使用的同一个实例，因此会出现线程安全问题
        VolatilSynchronizedRunnable sync = new VolatilSynchronizedRunnable();
        VolatilAtomicRunnable atomic = new VolatilAtomicRunnable();
        VolatilReentrantlockRunnable reentrantlockRunnable = new VolatilReentrantlockRunnable();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入线程安全方法(synchronized,atomic,reentrantlock):");
        String type = input.nextLine();
        Long startTime = System.currentTimeMillis();
        // 注意这里是创建一个实例，并且将该实例方法放入多线程运行；
        // 那么方法操作实例变量，也会导致线程不安全的问题
        for (int i = 0; i < 6; i++) {
            if ("synchronized".equals(type)) executor.execute(sync);
            else if ("atomic".equals(type)) executor.execute(atomic);
            else executor.execute(reentrantlockRunnable);
        }
        Thread.sleep(2000);
        System.out.println("spent time:"+(System.currentTimeMillis()-startTime)/1000+"s");
        System.out.println(sync.inc);
        System.out.println(atomic.inc);
        System.out.println(reentrantlockRunnable.inc);
        executor.shutdown();
    }


    public static void main(String[] args) throws InterruptedException {
        ThreadPoolExecutorTest();
    }

}
