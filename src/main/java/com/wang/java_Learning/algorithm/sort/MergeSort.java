package com.wang.java_Learning.algorithm.sort;

import java.util.Arrays;

public class MergeSort implements SortParent{
    @Override
    public void sort(int[] nums) {
        mergeSub(nums,0,nums.length-1);
    }

    private void mergeSub(int[] nums,int l,int r){
        if (l>=r) return;
        int mid = l+(r-l)/2;
        mergeSub(nums,l,mid);
        mergeSub(nums,mid+1,r);
        merge(nums,l,mid,r);
    }

    private void merge(int[] nums,int l,int mid,int r){
        int i = l,j = mid+1;
        int[] tmp = new int[r-l+1];
        int index=0;
        while (i<=mid && j<=r){
            while (i<=mid && nums[i]<nums[j]) tmp[index++] = nums[i++];
            while (j<=r && nums[j]<=nums[i]) tmp[index++] = nums[j++];
        }
        if (i<=mid){
            while (i<=mid) tmp[index++] = nums[i++];
        }else if (j<=r){
            while (j<=r) tmp[index++] = nums[j++];
        }
        index=0;
        for (int x=l;x<=r;x++){
            nums[x] = tmp[index++];
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{6,5,4,3,2,1};
        new MergeSort().sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
