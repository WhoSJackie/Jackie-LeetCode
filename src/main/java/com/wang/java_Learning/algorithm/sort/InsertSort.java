package com.wang.java_Learning.algorithm.sort;

public class InsertSort implements SortParent{

    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        for (int i=1;i<len;i++){
            int value = nums[i];
            int j=i-1;
            // 左边为有序区间，右边为无序区间
            // 找到合适的位置插入
            while (j>=0&&value<nums[j]){
                nums[j+1] = nums[j];
                j--;
            }
            // 一轮结束插入合适的值
            nums[j+1] = value;
        }
    }
}
