package com.wang.Leetcode.get_offer;

import java.util.Deque;
import java.util.LinkedList;

public class Offer31 {

    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> stack = new LinkedList<>();
        // 1.法一 模拟复杂版
//        int[] res = new int[pushed.length];
//        int pushIndex=0;
//        int resIndex=0;
//        for (int i=0;i<popped.length;i++){
//            int temp = popped[i];
//            // 如果stack里不包含temp，那就从push里面入栈到temp
//            if (!stack.contains(temp)){
//                while (pushed[pushIndex]!=temp){
//                    stack.offerFirst(pushed[pushIndex++]);
//                }
//                res[resIndex++] = temp;
//                pushIndex++;
//            } else{
//                if (stack.peekFirst()!=temp) {
//                    return false;
//                } else{
//                    Integer pollFirst = stack.pollFirst();
//                    res[resIndex++] = pollFirst;
//                }
//            }
//        }
//
//        for (int i = 0; i < popped.length; i++) {
//            if (res[i]!=popped[i]) return false;
//        }
//
//        return true;

        // 法二 模拟简单版
        for (int i=0,j=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        int[] testPush = new int[]{0,1};
        int[] testPop = new int[]{0,1};
        System.out.println(new Offer31().validateStackSequences(testPush, testPop));
    }

}
