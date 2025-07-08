package com.wang.java_Learning.MutiThread;

public class VolatilSynchronizedRunnable implements Runnable{

    public  int inc;

    public synchronized void increase(){
        inc++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 1000; i++) {
            increase();
        }
    }
}
