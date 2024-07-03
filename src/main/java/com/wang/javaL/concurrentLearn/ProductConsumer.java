package com.wang.javaL.concurrentLearn;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyShare {
    private volatile boolean FLAG = true;//默认开启，进行生产和消费
    AtomicInteger atomicInteger = new AtomicInteger();
    BlockingQueue<String> blockingQueue = null;

    public MyShare(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void myProd() throws Exception {
        String data = null;
        boolean result;
        while (FLAG) {
            data = String.valueOf(atomicInteger.incrementAndGet());
            result = blockingQueue.offer(data, 2L, TimeUnit.MICROSECONDS);
            if (result) {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列data:" + data + "成功");
            } else {
                System.out.println(Thread.currentThread().getName() + "\t 插入队列data:" + data + "失败");
            }
            //一秒生产一个
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        System.out.println(Thread.currentThread().getName() + "\t 生产被叫停，Flag为false");

    }

    public void myConsumer() throws Exception {
        String value = null;
        while (FLAG) {
            value = blockingQueue.poll(2, TimeUnit.SECONDS);
            if (value == null || value.equalsIgnoreCase("")) {
//                FLAG = false;
                System.out.println(Thread.currentThread().getName() + "\t 超过两秒没收到消息");
                System.out.println("");
                System.out.println("");
                System.out.println("");
                return;
            }
            System.out.println(Thread.currentThread().getName() + "\t 消费队列value：" + value + "成功");
        }
    }

    public void stop() {
        FLAG = false;
    }
}

/**
 * @author liujian
 * @descripts 生产者消费者阻塞队列版
 * @create 2019-06-24 22:43
 */
public class ProductConsumer {
    public static void main(String[] args) {
        MyShare myShare = new MyShare(new ArrayBlockingQueue<>(10));
        new Thread(() -> {
            System.out.println("生产线程启动");
            try {
                myShare.myProd();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "product").start();

        new Thread(() -> {
            System.out.println("消费线程启动");
            try {
                System.out.println("");
                System.out.println("");
                System.out.println("");
                myShare.myConsumer();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }, "consumer").start();
        //休眠五秒
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        myShare.stop();
    }


}
