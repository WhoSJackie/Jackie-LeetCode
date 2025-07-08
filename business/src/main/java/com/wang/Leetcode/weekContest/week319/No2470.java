package com.wang.Leetcode.weekContest.week319;

public class No2470 {

    public int subarrayLCM(int[] nums, int k) {
        int len = nums.length;
        int count=0;
        for (int i=0;i<len;i++){
            int temp = nums[i];
            for (int j = i;j<len;j++){
                temp = temp*nums[j]/gcd(temp,nums[j]);
                if (temp==k){
                    count++;
                }
                if (temp>k){
                    break;
                }
            }
        }

        return count;
    }

    private int gcd(int a,int b){
        if (a<b){
            int temp = b;
            b = a;
            a = temp;
        }
        while(b!=0){
            int temp = a%b;
            a = b;
            b = temp;
        }
        return a;
    }

}
