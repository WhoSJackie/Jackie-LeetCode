package com.wang.Leetcode.get_offer;

public class Offer63 {

        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len<=1) return 0;
            if (len==2){
                return prices[1]>prices[0]?(prices[1]-prices[0]):0;
            }
            // 0代表当前没有股票，1代表当前持有股票
            int[][] dp = new int[len+1][2];
            dp[1][0] = 0;
            dp[1][1] = -prices[0];
            int maxValue=0;
            for (int i = 2; i <= len; i++) {
                dp[i][0] = Math.max(dp[i-1][1]+prices[i-1],0);
                dp[i][1] = Math.max(-prices[i-1],dp[i-1][1]);
                maxValue = Math.max(dp[i][0],maxValue);
            }
            return maxValue;
        }


    public static void main(String[] args) {
        int[] question = {1,2,4};
        System.out.println(new Offer63().maxProfit(question));

    }
}
