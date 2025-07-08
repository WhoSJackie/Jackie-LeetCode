package com.wang.Leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    Deque<Integer> stack;
    Deque<Integer> stackMin;

    public MinStack() {
        stack = new ArrayDeque<>();
        stackMin = new ArrayDeque<>();
    }

    public void push(int val) {
        if (!stackMin.isEmpty()){
            if (val<=stackMin.peek()) stackMin.push(val);
        } else{
            stackMin.push(val);
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.isEmpty()) return;
        if (stack.peek().equals(stackMin.peek())) stackMin.pop();
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stackMin.peek();
    }

  public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      minStack.getMin();
      minStack.pop();
      minStack.top();
      minStack.getMin();
  }
}




