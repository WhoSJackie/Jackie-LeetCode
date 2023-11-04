package com.wang.Leetcode;

public class No188 {

    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        int l = Math.min(len/2+1,k); // 实际交易量不会超过总天数/2向上取整，不然就没有意义
        int[] buy = new int[l];
        int[] sell = new int[l];
        for (int i=0;i<l;i++){
            buy[i] = -prices[0];
            sell[i] = 0;
        }
        for (int i = 1; i < len; i++) {
            buy[0] = Math.max(buy[0],-prices[i]);
            sell[0] = Math.max(sell[0],buy[0]+prices[i]);
            for (int j=1;j<l;j++){
                buy[j] = Math.max(buy[j],sell[j-1]-prices[i]);
                sell[j] = Math.max(sell[j],buy[j]+prices[i]);
            }
        }
        return sell[l-1];
    }

}
