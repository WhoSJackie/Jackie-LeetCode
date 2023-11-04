package com.wang.Leetcode;

public class No122 {

    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res = 0;
        for (int i = 1; i < len; i++) {
            if (prices[i]-prices[i-1]>0){
                res+=prices[i]-prices[i-1];
            }
        }
        return res;
    }
}
