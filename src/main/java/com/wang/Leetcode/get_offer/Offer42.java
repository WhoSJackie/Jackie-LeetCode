package com.wang.Leetcode.get_offer;

public class Offer42 {

    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len<=1) return Math.max(nums[0],0);
        int[] dp = new int[len];
        dp[0] = Math.max(0,nums[0]);
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
        }
        return dp[len-1];
    }

}
