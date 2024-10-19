package com.wang.Leetcode;

import java.util.Arrays;

public class No2160 {

    public int minimumSum(int num) {
        int[] nums = new int[4];
        // 求出各位置的数
        int a = num;
        int b = a;
        int ix=0;
        while (a!=0){
            b = a%10;
            nums[ix++] = b;
            a = a/10;
        }
        Arrays.sort(nums);
        return nums[0]*10+nums[3]+nums[1]*10+nums[2];
    }

    public static void main(String[] args) {
        System.out.println(new No2160().minimumSum(2932));
    }


}
