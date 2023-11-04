package com.wang.Leetcode.weekContest.week352;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No6911 {

    public long continuousSubarrays(int[] nums) {
        int len = nums.length;
        int cnt=nums.length;
        Set<String> repArr = new HashSet<>();
        for (int i=2;i<=len;i++){
            for (int l=0;l<len;l++){
                if ((l+i-1)>=len) break;
                if (isContinousArr(nums,l,l+i-1)){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private boolean isContinousArr(int[] nums,int l,int r){
        int max=0;
        int min=Integer.MAX_VALUE;
        for (int i=l;i<=r;i++){
            max = Math.max(nums[i],max);
            min = Math.min(nums[i],min);
        }
        return max-min<=2;
    }

    public static void main(String[] args) {
        System.out.println(new No6911().continuousSubarrays(new int[]{1,2,3}));
    }

}
