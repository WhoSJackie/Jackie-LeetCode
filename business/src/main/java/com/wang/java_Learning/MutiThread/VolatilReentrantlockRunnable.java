package com.wang.java_Learning.MutiThread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class VolatilReentrantlockRunnable implements Runnable{

    public  int inc;

    public synchronized void increase(){
        inc++;
    }

    ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        lock.lock();
        try{
            for (int i = 0; i < 1000; i++) {
                increase();
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
