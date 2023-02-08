package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1742 {

    public int countBalls(int lowLimit, int highLimit) {
         int max = 0;
         int[] arr = new int[50];
         int num;
         int numCount;
         for (int i=lowLimit;i<=highLimit;i++){
             num = countNum(i);
             arr[num]++;
             max = Math.max(arr[num],max);
         }
         return max;
    }

    private int countNum(int num){
        int a = num/10;
        int count = num%10;
        while (a!=0){
            count+=a%10;
            a = a/10;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new No1742().countBalls(1, 10));
    }

}
