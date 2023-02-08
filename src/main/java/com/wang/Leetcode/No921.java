package com.wang.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class No921 {

    public int minAddToMakeValid(String s) {
        Deque<Character> stack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case ')':
                    if (!stack.isEmpty()){
                        if (stack.peek()=='('){
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                    } else{
                        stack.push(')');
                    }
                    break;
                case '(':
                    if (!stack.isEmpty()){
                        stack.push('(');
                    } else{
                        stack.push('(');
                    }
                    break;
            }
        }

        return stack.size();
    }


}
