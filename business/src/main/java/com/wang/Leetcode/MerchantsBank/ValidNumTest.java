package com.wang.Leetcode.MerchantsBank;

public class ValidNumTest {

    public int validNum (int N) {
        int[][] dp = new int[N+1][N+1];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i=2;i<=N;i++){
            dp[i][0] = dp[i-1][1];
            dp[i][1] = dp[i-1][0]+dp[i-1][1];
        }

        return dp[N][0]+dp[N][1];
    }

    public static void main(String[] args) {
        System.out.println(new ValidNumTest().validNum(4));
    }

}
