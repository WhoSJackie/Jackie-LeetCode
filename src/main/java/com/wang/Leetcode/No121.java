package com.wang.Leetcode;

public class No121 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int[] dp = new int[len];
        int res=0;
        for (int i=1;i<len;i++){
            dp[i] = Math.max(dp[i-1]+(prices[i]-prices[i-1]),dp[i]);
            res = Math.max(res,dp[i]);
        }
        return res;
    }


    public static void main(String[] args) {

    }

}
