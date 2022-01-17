package com.wang.Leetcode;

import java.util.Stack;

public class No1221 {
    public static int balancedStringSplit(String s) {
        int len=s.length();
        Stack<Character> stack=new Stack<>();
        int count=0;
        int i=1;
        stack.push(s.charAt(0));
        while(i<len) {

            if(s.charAt(i)=='L'){
                char t=stack.peek();
                if(t=='R'){
                    stack.pop();
                    if(stack.size()==0){
                        count++;
                        if(i+1>=len){
                            break;
                        }
                        stack.push(s.charAt(++i));
                        i++;
                    }
                    else{
                        i++;
                    }
                }
                else{
                    stack.push(t);
                    i++;
                }
            }

            else{
                char t1=stack.peek();
                if(t1=='L'){
                    stack.pop();
                    if(stack.size()==0){
                        count++;
                        if(i+1>=len){
                            break;
                        }
                        stack.push(s.charAt(++i));
                        i++;
                    }
                    else{
                        i++;
                    }
                }
                else{
                    stack.push(t1);
                    i++;
                }
            }
        }
        return count;

    }

    public static void main(String[] args) {
        System.out.println(balancedStringSplit("RLLLLRRRLR"));
    }
}
