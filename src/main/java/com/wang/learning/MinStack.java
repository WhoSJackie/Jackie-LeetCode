package com.wang.learning;

import java.sql.Array;
import java.util.*;


public class MinStack {
        private Integer min;
        private LinkedList<Integer> stack;

        /** initialize your data structure here. */
        public MinStack() {
            min=Integer.MAX_VALUE;
            stack=new LinkedList<>();
        }

        public void push(int x) {
           stack.push(x);
           if(x<=min){
              min=x;
           }
        }

        public void pop() {
            if(!stack.isEmpty()){
                Integer cur=stack.pop();
                if(cur.equals(min)){
                    if(!stack.isEmpty()){
                        min=stack.peek();
                        for (Integer integer : stack) {
                            min=Math.min(min,integer);
                        }
                    }
                }
            }
            //栈为空，min重新初始化
            if(stack.isEmpty()){
                min=Integer.MAX_VALUE;
            }
        }

        public int top() {
           if(!stack.isEmpty()){
               stack.peek();
           }
           return -1;
        }

        public int min() {
            return min;
        }

  public static void main(String[] args) {
      MinStack minStack = new MinStack();
      minStack.push(-2);
      minStack.push(0);
      minStack.push(-3);
      minStack.min();
      minStack.pop();
      minStack.top();
      minStack.min();
  }
}




