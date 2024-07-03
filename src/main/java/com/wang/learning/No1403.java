package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No1403 {
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 倒序排列nums
        quickSort(nums,0,nums.length-1);

        // 计算数组和
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        sum = sum/2;

        int cur=0;
        for (int i = 0; i < nums.length; i++) {
            res.add(nums[i]);
            cur+=nums[i];
            if (cur>sum){
                break;
            }
        }
        return res;
    }

    private void quickSort(int[] arr,int l,int r){
        if (l>=r){
            return;
        }
        int temp = arr[l];
        int i=l;
        int j=r;

        while(i<j){
            while(i<j&&arr[j]<temp) j--;
            while(i<j&&arr[i]>=temp) i++;
            int tnum = arr[i];
            arr[i] = arr[j];
            arr[j] = tnum;
        }

        arr[l] = arr[i];
        arr[i] = temp;
        quickSort(arr,i+1,r);
        quickSort(arr,l,i-1);
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,7,4,7,1,9,4,8,8};
        new No1403().minSubsequence(nums);
    }

}
