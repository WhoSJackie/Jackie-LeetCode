package com.wang.java_Learning.MutiThread.concurrentLearn;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class WhatReentrant {

    public static void main(String[] args) {
        ReentrantLock lick=new ReentrantLock();

        //使用synchronized实现同步
//        Runnable runnable=new Runnable() {
//            @Override
//            public void run() {
//                synchronized (this){
//                    System.out.println("第1次获取这个锁，该锁是"+this);
//                    int index=1;
//                    while(true){
//                        synchronized (this){
//                            System.out.println("第"+(++index)+"次获取锁，该锁是"+this);
//                        }
//                        if(index==10){
//                            break;
//                        }
//                    }
//                }
//            }
//        };

        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    int index=0;
                    for (int i = 0; i < 20; i++) {
                        System.out.println("当前thread为" + Thread.currentThread().getName()+"第"+(++index)+"次获取锁");
                    }
                    try {
                        Thread.sleep(new Random().nextInt(200));

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        for (int i = 0; i < 10; i++) {
            Thread thread=new Thread(runnable);
            thread.start();
        }


    }
}
