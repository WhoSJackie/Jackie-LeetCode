package com.wang.learning;

public class No1480 {
    public int[] runningSum(int[] nums) {
        int len=nums.length;
        int[] n=new int[len];
        n[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            n[i]=n[i-1]+nums[i];
        }

        return n;

    }


}
