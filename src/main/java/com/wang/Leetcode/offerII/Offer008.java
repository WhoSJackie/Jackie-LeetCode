package com.wang.Leetcode.offerII;

public class Offer008 {

    public int minSubArrayLen(int target, int[] nums) {
        int l = 0;
        int r = 0;
        int len = 0;
        int curSum=nums[l];
        while (l<=r&&r<nums.length){
            while (curSum<target){
                r++;
                if (r>=nums.length) break;
                curSum+=nums[r];
            }

            if (curSum>=target){
                len = Math.min(len,r-l+1);
                curSum-=nums[l];
                l++;
            }
        }
        return len;
    }

}
