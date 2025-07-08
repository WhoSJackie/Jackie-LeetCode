package com.wang.Leetcode.get_offer;

import java.util.Deque;
import java.util.LinkedList;

public class MaxQueue {
    Deque<Integer> queue;
    Deque<Integer> stack;

    public MaxQueue() {
        queue = new LinkedList<>();
        stack = new LinkedList<>();
    }

    public int max_value() {
        if (queue.isEmpty()||stack.isEmpty()) return -1;
        return stack.peekFirst();
    }

    public void push_back(int value) {
        queue.offerLast(value);
        if (stack.isEmpty()||(value>=stack.peekFirst())) {
            stack.offerFirst(value);
        }
    }

    public int pop_front() {
        if (queue.isEmpty()) return -1;
        if (!stack.isEmpty()&&(stack.peekFirst().equals(queue.peekFirst()))){
            stack.pollFirst();
        }
        return queue.pollFirst();
    }
}
