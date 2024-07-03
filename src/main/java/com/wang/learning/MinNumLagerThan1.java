package com.wang.learning;

public class MinNumLagerThan1 {

    public int getMinNum(int[] nums){
        if (nums.length==0){
            return 1;
        }
        int minusMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            minusMin = Math.min(minusMin,nums[i-1]+nums[i]);
        }
        return Math.abs(minusMin)+1;
    }
}
