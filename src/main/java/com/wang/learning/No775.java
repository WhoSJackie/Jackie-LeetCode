package com.wang.learning;

public class No775 {

    public boolean isIdealPermutation(int[] nums) {
        // 暴力方法 n^2
//        int len = nums.length;
//        for (int i = 0; i < len; i++) {
//            for (int j = i+2; j < len; j++) {
//                if (nums[i]>nums[j]){
//                    return false;
//                }
//            }
//        }
//        return true;

        // 进一步存储每一个位置i右边的最小值min，这样只要满足nums[i]>min便可以找到不是局部倒置的全局倒置
        int[] temp = new int[nums.length];
        int min = Integer.MAX_VALUE;
        for (int i = nums.length-1; i >=0; i--) {
            if (nums[i]<min){
                min = nums[i];
            }
            temp[i] = min;
        }

        for (int i = 0; i < nums.length-2; i++) {
            if (nums[i]>temp[i+2]){
                return false;
            }
        }
        return true;
    }

}
