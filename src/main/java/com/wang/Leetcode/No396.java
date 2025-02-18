package com.wang.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class No396 {

    // 超时
    public static class TimeOut{
        public int maxRotateFunction(int[] nums) {
            int max=Integer.MIN_VALUE;;
            int sum=0;
            for (int i = 0; i < nums.length; i++) {
                // 计算轮转
                for (int j = 0; j < nums.length; j++) {
                    // 轮转n-1次
                    sum += j*nums[j];
                }
                max = Math.max(sum,max);
                sum=0;
                reverse(nums,0,nums.length-1);
                reverse(nums,1,nums.length-1);
            }
            return max;
        }

        private void reverse(int[] nums,int i,int j){
            while (i<j) {
                int temp = nums[j];
                nums[j--] = nums[i];
                nums[i++] = temp;
            }
        }
    }

    // 比较两轮计算结果之间的差，进而进行迭代
    public int maxRotateFunction(int[] nums) {
        int len = nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        int allSum = 0;
        for (int j = 0; j < len; j++) {
            // 轮转n-1次
            sum += j*nums[j];
            allSum+=nums[j];
        }
        for (int i = 1; i <= nums.length; i++) {
            // 计算轮转
            max = Math.max(sum,max);
            sum = sum+allSum-len*(nums[len-i]);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new No396().maxRotateFunction(new int[]{4, 3, 2, 6}));
    }

}
