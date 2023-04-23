package com.wang.java_Learning.MutiThread;

import java.text.SimpleDateFormat;
import java.util.Random;

public class ThreadLocalTest implements Runnable{

    public static final ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(()->new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));


    public static void main(String[] args) throws InterruptedException {
        ThreadLocalTest local = new ThreadLocalTest();
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(local," "+i);
            Thread.sleep(new Random().nextInt(1000));
            thread.start();
        }
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"->default formatter->"+sdf.get().toPattern());

        try{
            Thread.sleep(new Random().nextInt(1000));
        } catch (Exception e){
            e.printStackTrace();
        }

        sdf.set(new SimpleDateFormat());
        System.out.println(Thread.currentThread().getName()+"->"+sdf.get().toPattern());
    }
}
