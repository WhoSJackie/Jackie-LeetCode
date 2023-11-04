package com.wang.Leetcode.weekContest.week349;

import java.util.Arrays;

public class FindNoMaxNorMinNum {
    private static final int NO_ANS = -1;

    public int findNoMaxNorMin(int[] nums){
        int len = nums.length;
        if (len<=2) return NO_ANS;
        Arrays.sort(nums);
        int i = 0;
        int j = len-1;
        for (int x=1;x<len-1;x++){
            if (nums[x]>nums[i]&&nums[x]<nums[j]) return nums[x];
        }
        return NO_ANS;
    }





}
