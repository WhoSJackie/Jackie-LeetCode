package com.wang.Leetcode.get_offer;

import java.util.ArrayDeque;
import java.util.Deque;

public class CQueue {

    Deque<Integer> stack1;
    Deque<Integer> stack2;

    public CQueue() {
        stack1 = new ArrayDeque<>();
        stack2 = new ArrayDeque<>();
    }

    public void appendTail(int value) {
        stack1.addFirst(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                stack2.addFirst(stack1.removeFirst());
            }
        }
        return stack2.isEmpty()?-1:stack2.removeFirst();
    }
}
