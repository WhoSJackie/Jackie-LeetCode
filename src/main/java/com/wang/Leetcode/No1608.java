package com.wang.Leetcode;

import java.util.Arrays;

public class No1608 {

    public int specialArray(int[] nums) {
        // 找到最大值
        Arrays.sort(nums);

        // 循环到max
        for (int i = 0; i <= nums[nums.length-1]; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j]>=i){
                    if (i==(nums.length-j)){
                        return i;
                    }
                    break;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        System.out.println(new No1608().specialArray(new int[]{0,4,3,0,4}));
    }

}
