package com.wang.learning;

public class No268 {
    public int missingNumber(int[] nums) {
        int len=nums.length;
        int[] sort=new int[len+1];
        for (int i = 0; i < len; i++) {
            sort[nums[i]]=1;
        }
        int res=-1;
        for (int i = 0; i < sort.length; i++) {
            if(sort[i]==0){
                res=i;
            }
        }
        return res;
    }
}
