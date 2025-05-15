package com.wang.java_Learning.collection;

import java.util.Date;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayedQueue {

    private static String name1="aaa";

    private String name2="bbb";
    public static void main(String[] args) throws InterruptedException {
        DelayQueue queue = new DelayQueue();
        queue.add(new DelayElement("x",1000L));
        queue.add(new DelayElement("y",2000L));
        queue.add(new DelayElement("z",3000L));
        while (!queue.isEmpty()){
            // 只取到延迟时间的元素
            DelayElement delayElement = (DelayElement)queue.take();
            delayElement.accessOuter();
            System.out.println(delayElement.getName()+"-->"+new Date());
            // 未到延迟时间会返回null
//            System.out.println(queue.poll()+"-->"+new Date());
        }
    }

    static class DelayElement implements Delayed{

        private String name;
        // 单位：ms
        private Long time;

        public DelayElement(String name,Long time){
            this.name = name;
            this.time = System.currentTimeMillis()+time;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            return (int)(this.time-((DelayElement)o).getTime());
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getTime() {
            return time;
        }

        public void setTime(Long time) {
            this.time = time;
        }
        public void accessOuter(){
            System.out.println(name1);
            // 需要通过外部类实例化对象访问
            System.out.println(new DelayedQueue().name2);
        }
    }

}
