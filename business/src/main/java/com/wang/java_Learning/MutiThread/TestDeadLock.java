package com.wang.java_Learning.MutiThread;

public class TestDeadLock {

    private static Object res1 = new Object();
    private static Object res2 = new Object();

    public static void main(String[] args) {
//        showObjectSynchronized();
        showDeadLock();
    }

    public static void showDeadLock(){
        new Thread(()->{
            synchronized(res1){
                System.out.println(Thread.currentThread().getName()+"->获取锁res1...");
                try{
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName() + "->获取到锁res1");
                } catch(Exception e){
                    System.out.println(e.toString());
                }
                System.out.println(Thread.currentThread().getName()+"->Waiting for the lock res2...");
                synchronized (res2){
                    System.out.println(Thread.currentThread().getName()+"->获取到锁res2");
                }
            }
        },"Thread-01").start();

        new Thread(()->{
            synchronized(res2){
                System.out.println(Thread.currentThread().getName()+"->获取锁res2...");
                try{
                    Thread.sleep(1000);
                    System.out.println(Thread.currentThread().getName()+"->获取到锁res2");
                } catch(Exception e){
                    System.out.println(e.toString());
                }
                System.out.println(Thread.currentThread().getName()+"->Waiting for the lock res1...");
                synchronized (res1){
                    System.out.println(Thread.currentThread().getName()+"->获取到锁res1");
                }
            }
        },"Thread-02").start();
    }

    public static void showObjectSynchronized(){
        // 锁实例对象的例子
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
