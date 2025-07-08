package com.wang.Leetcode;

import java.util.ArrayDeque;
import java.util.Queue;

public class MovingAverage {
    private Queue<Integer> queue;
    private Integer size;
    private double sum=0;


    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        queue = new ArrayDeque<>();
        this.size = size;
    }

    public double next(int val) {
        if (queue.size()>=size){
            if (queue.element()!=null){
                sum-=queue.poll();
            }
        }
        queue.add(val);
        return sum/queue.size();
    }

}
