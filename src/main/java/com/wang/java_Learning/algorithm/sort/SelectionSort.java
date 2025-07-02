package com.wang.java_Learning.algorithm.sort;

import com.wang.java_Learning.utils.ArrayUtil;

public class SelectionSort implements SortParent{
    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len-1; i++) {
            int minPos = i;
            for (int j = i+1; j < len; j++) {
                if (nums[minPos]>nums[j]) minPos = j;
            }
            ArrayUtil.swap(nums,minPos,i);
        }
    }
}
