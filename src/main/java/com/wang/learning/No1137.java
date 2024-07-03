package com.wang.learning;

public class No1137 {
    public int tribonacci(int n) {
        int[] dp=new int[3];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <= n; i++) {
            dp[i%3]=dp[0]+dp[1]+dp[2];
        }
        return dp[n%3];
    }
}
