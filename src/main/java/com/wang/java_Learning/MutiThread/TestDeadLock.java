package com.wang.java_Learning.MutiThread;

public class TestDeadLock {

    private static Object res1 = new Object();
    private static Object res2 = new Object();

    public static void main(String[] args) {
        // 线程1
        new Thread(()->{
            synchronized (res1){
                System.out.println(Thread.currentThread().getName()+"->get Resource1");
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"->waiting to get Resource2");
                synchronized (res2){
                    System.out.println(Thread.currentThread().getName()+"->get Resource2");
                }
            }
        },"线程1").start();

        new Thread(()->{
            synchronized (res1){
                System.out.println(Thread.currentThread().getName()+"->get Resource1");
                try{
                    Thread.sleep(1000);
                } catch (Exception e){
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"->waiting to get Resource2");
                synchronized (res2){
                    System.out.println(Thread.currentThread().getName()+"->get Resource2");
                }
            }
        },"线程2").start();

    }


}
