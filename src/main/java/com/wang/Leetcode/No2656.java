package com.wang.Leetcode;

import java.util.Arrays;

public class No2656 {

    public int maximizeSum(int[] nums, int k) {
        Arrays.sort(nums);
        int len = nums.length;
        int sum=0;
        for (int i = 0; i < k; i++) {
            sum+=(nums[len-1]+i);
        }
        return sum;
    }

}
