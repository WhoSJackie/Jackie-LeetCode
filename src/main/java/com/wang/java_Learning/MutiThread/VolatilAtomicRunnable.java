package com.wang.java_Learning.MutiThread;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatilAtomicRunnable implements Runnable{

    public  AtomicInteger inc  = new AtomicInteger();

    public synchronized void increase(){
        inc.getAndIncrement();
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increase();
        }
    }
}
