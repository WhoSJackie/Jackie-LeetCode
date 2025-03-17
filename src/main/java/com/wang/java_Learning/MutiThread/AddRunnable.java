package com.wang.java_Learning.MutiThread;

public class AddRunnable implements Runnable{

    public static int counter;

    public AddRunnable(int counter){
        this.counter = counter;
    }

    @Override
    public void run() {
        counter = 2*counter;
        System.out.println(counter);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new AddRunnable(100),"线程"+i);
            thread.start();
        }
    }
}
