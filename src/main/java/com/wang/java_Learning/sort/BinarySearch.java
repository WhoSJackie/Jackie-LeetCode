package com.wang.java_Learning.sort;

import java.util.HashMap;
import java.util.Map;

public class BinarySearch {

    public int NormalBinarySearch(int[] nums,int target){
        int left = 0;
        int right = nums.length-1;
        while (left <= right){
            int mid = left + (right-left)/2;
            if (nums[mid]==target) {
                return mid;
            } else if(nums[mid]>target) {
                right = mid-1;
            } else{
                left = mid+1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0,1,3,4,6,7,8,9};
        System.out.println(new BinarySearch().NormalBinarySearch(nums, 6));
    }









}
