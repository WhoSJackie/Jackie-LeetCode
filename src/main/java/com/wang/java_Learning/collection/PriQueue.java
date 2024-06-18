package com.wang.java_Learning.collection;

import java.util.PriorityQueue;

public class PriQueue {

    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)-> Integer.compare(0, a-b));
        queue.offer(1);
        queue.offer(5);
        queue.offer(3);
        queue.offer(7);
        queue.offer(2);
        System.out.println(queue.peek());
    }


}
