package com.wang.Leetcode.get_offer;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> stackMin;
    /** initialize your data structure here. */
    public MinStack() {
        stack = new LinkedList<>();
        stackMin = new LinkedList<>();
    }

    public void push(int x) {
        stack.addFirst(x);
        // 处理min栈
        if (stackMin.isEmpty()||x<=stackMin.peekFirst()){
            stackMin.addFirst(x);
        }
    }

    public void pop() {
        if (!stack.isEmpty()&&!stackMin.isEmpty()) {
            if (stackMin.peekFirst().equals(stack.peekFirst())){
                stackMin.removeFirst();
            }
            stack.removeFirst();
        }
    }

    public int top() {
        if (stack.isEmpty()) return -1;
        return stack.peekFirst();
    }

    public int min() {
        return stackMin.isEmpty()?-1:stackMin.peekFirst();
    }

}
