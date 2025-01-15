package com.wang.Leetcode;

public class No453 {

    public int minMoves(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i : nums) {
            min  = Math.min(i,min);
            sum += i;
        }
        return sum-n*min;
    }

}
