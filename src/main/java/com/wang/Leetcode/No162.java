package com.wang.Leetcode;

public class No162 {

    public int findPeakElement(int[] nums) {
        int len = nums.length;
        int l = 0;
        int m = 1;
        int r = 2;
        if (len==1) return 0;
        if (len==2) return nums[0]>nums[1]?0:1;
        // 处理峰值位于边界的情况
        if (nums[0]>nums[1]) return 0;
        if (nums[len-1]>nums[len-2]) return len-1;
        // 正常情况,使用三指针
        while (r<len) {
            if ((nums[m]>nums[l])&&(nums[m]>nums[r])){
                return m;
            }
            l++;
            m++;
            r++;
        }

        return -1;
    }

}
