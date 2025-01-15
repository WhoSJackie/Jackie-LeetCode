package com.wang.java_Learning.sort;

public class QuickSort implements SortParent{


    @Override
    public void sort(int[] nums) {
        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums,int low,int high){
        if (low>=high) return;
        int temp = nums[low];
        int l = low;
        int h = high;
        while (l<h){
            while (l<h && nums[h]>=temp) h--;
            while (l<h && nums[l]<=temp) l++;
            // 交换两个位置
            if (l<h){
                int tmp = nums[h];
                nums[h] = nums[l];
                nums[l] = tmp;
            }
        }
        nums[low] = nums[l];
        nums[l] = temp;
        quickSort(nums,low,l-1);
        quickSort(nums,l+1,high);
    }


}
