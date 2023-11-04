package com.wang.Leetcode;

import java.util.Arrays;

public class No2475 {
    public int unequalTriplets(int[] nums) {
        int count=0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                for (int k = j+1; k < len; k++) {
                    if (nums[i]!=nums[j]){
                        count+=nums[i]!=nums[k]?(nums[j]!=nums[k]?1:0):0;
                    }
                }
            }
        }
        return count;
    }


    public int unequalTriplets1(int[] nums){
        int len = nums.length;
        Arrays.sort(nums);
        int res=0;
        for (int i=0,j=0;i<len;i=j){
            while (j<len&&nums[i]==nums[j]){
                j++;
            }
            res+=i*(j-i)*(len-j);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new No2475().unequalTriplets1(new int[]{4, 4, 2, 4, 3,5}));
    }

}
