package com.wang.Leetcode.get_offer;

public class Offer14I {

    public int cuttingRope(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=2;i<=n;i++){
            for (int j=1;j<i;j++){
                dp[i] = Math.max(dp[i],Math.max(j*(i-j),j*dp[i-j]));
            }
        }
        System.out.println(dp[n]);
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Offer14I().cuttingRope(10));
    }

}
