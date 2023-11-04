package com.wang.Leetcode;

public class No123 {

    public int maxProfit(int[] prices) {
        int buy1=-prices[0];
        int sell1 = 0;
        int buy2 = -prices[0];
        int sell2 = 0;
        int len = prices.length;
        for (int i = 1; i < len; i++) {
            buy1 = Math.max(buy1,-prices[i]);
            sell1 = Math.max(sell1,prices[i]+buy1);
            buy2 = Math.max(buy2,sell1-prices[i]);
            sell2 = Math.max(sell2,prices[i]+buy2);
        }

        return Math.max(sell1,sell2);
    }


}
