package com.wang.Leetcode.weekContest.week267;

import java.util.Arrays;

public class No2903 {

    //1.法一 两次遍历
//    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
//        int[] res = new int[]{-1,-1};
//        for (int i = 0; i < nums.length; i++) {
//            for (int j=i;j<nums.length;j++){
//                if ((Math.abs(j-i)>=indexDifference)&&(Math.abs(nums[j]-nums[i])>=valueDifference)){
//                    res[0] = i;
//                    res[1] = j;
//                    return res;
//                }
//            }
//        }
//        return res;
//    }

    // 2.法二 双指针+存储最大最小值
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int maxIndex = 0,minIndex = 0;
        int len = nums.length;
        for (int x = indexDifference; x < len; x++) {
            int y = x-indexDifference;
            if (nums[maxIndex]<nums[y]) maxIndex = y;
            if (nums[minIndex]>nums[y]) minIndex = y;
            if (nums[maxIndex]-nums[x]>=valueDifference){
                return new int[]{maxIndex,x};
            }
            if (nums[x]-nums[minIndex]>=valueDifference){
                return new int[]{minIndex,x};
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int[] res = new No2903().findIndices(new int[]{3,0,7},2,4);
        System.out.println(Arrays.toString(res));
    }


}
