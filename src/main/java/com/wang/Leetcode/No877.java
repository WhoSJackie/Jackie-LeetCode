package com.wang.Leetcode;

import java.util.Arrays;

public class No877 {

    // 法一 记忆化递归
//    int[][] memo;
//    int[] piles;
//    public boolean stoneGame(int[] piles) {
//        int len = piles.length;
//        this.piles = piles;
//        memo = new int[len][len];
//        // 初始化memo数组
//        for (int i = 0; i < len; i++) {
//            Arrays.fill(memo[i],Integer.MIN_VALUE);
//            memo[i][i] = piles[i];
//        }
//        return dfs(0,len-1)>0;
//    }
//
//    public int dfs(int l,int r){
//        if (l==r) return piles[l];
//        if (memo[l][r]!=Integer.MIN_VALUE) return memo[l][r];
//
//        int chooseLeft = piles[l]-dfs(l+1,r);
//        int chooseRight = piles[r]-dfs(l,r-1);
//        int temp = Math.max(chooseLeft,chooseRight);
//        memo[l][r] = temp;
//        return temp;
//    }

    // 法二 动态规划
    public boolean stoneGame(int[] piles) {
        int len = piles.length;
        // 记录先手的相对分数
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        // 欲求出dp[i][j]先必须求出dp[i+1][j]和dp[i][j-1]
        for (int j=1;j<len;j++){
            for (int i=j-1;i>=0;i--){
                dp[i][j] = Math.max(piles[i]-dp[i+1][j],piles[j]-dp[i][j-1]);
            }
        }
        return dp[0][len-1]>0;
    }



}
