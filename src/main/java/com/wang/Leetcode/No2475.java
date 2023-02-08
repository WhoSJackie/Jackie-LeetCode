package com.wang.Leetcode;

public class No2475 {
    public int unequalTriplets(int[] nums) {
        int count=0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                for (int k = 0; k < len; k++) {
                    if (nums[i]!=nums[j]){
                        count+=nums[i]!=nums[k]?(nums[j]!=nums[k]?1:0):0;
                    }
                }
            }
        }
        return count;
    }

}
