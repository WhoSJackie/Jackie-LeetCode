package com.wang.common.utils;

public class ArrayUtil {

    public static void  swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
