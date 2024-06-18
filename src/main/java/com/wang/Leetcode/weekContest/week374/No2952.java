package com.wang.Leetcode.weekContest.week374;

import java.util.Arrays;

public class No2952 {

    public int minimumAddedCoins(int[] coins, int target) {
        Arrays.sort(coins);
        int sum=1,res=0,i=0;
        while (sum<target){
            if (i<coins.length&&coins[i]<=sum) {
                    sum+=coins[i];
                    i++;
                } else{
                    res++;
                    sum=2*sum;
                }
            }
        return res;
    }


}
