package com.wang.java_Learning.sort;

public class BubbleSort implements SortParent{


    @Override
    public void sort(int[] nums) {
        int len = nums.length;
        // 如果有一趟没有交换，设置为true
        boolean flag = false;
        for (int i=0;i<len;i++){
            flag = false;
            for (int j=0;j<len-1;j++){
                if (nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }
}
