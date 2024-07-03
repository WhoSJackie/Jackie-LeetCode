package com.wang.learning;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No446 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len=nums.length;
        if(len<3){
            return 0;
        }
        Map<Long,Integer>[] dp=new Map[len];
        for (int i = 0; i < len; i++) {
            dp[i]=new HashMap<>();
        }
        int sum=0;
        int cnt=0;
        for (int i = 0; i < len; i++) {
            for(int j=0;j<i;j++){
                long d=nums[i]-nums[j];
                cnt=dp[j].getOrDefault(d,0);
                sum+=cnt;
                dp[i].put(d,dp[i].getOrDefault(d,0)+cnt+1);
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        No446 n=new No446();
        int[] nums={7,7,7,7,7};
        System.out.println(n.numberOfArithmeticSlices(nums));
    }
}
