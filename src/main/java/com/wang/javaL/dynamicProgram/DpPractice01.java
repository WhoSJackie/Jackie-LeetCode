package com.wang.javaL.dynamicProgram;

public class DpPractice01 {

    //递归版
    public int climbLadder(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        return climbLadder(n-1)+climbLadder(n-2);
    }

    //动态规划版
    public int climbLadder1(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        int[] dp = new int[n+1];
        // 初始化结束条件
        dp[1]=1;
        dp[2]=2;
        for (int i=3;i<=n;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    // 动态规划优化版
    public int climbLadder2(int n){
        if (n==1) return 1;
        if (n==2) return 2;
        int res = 0;
        int pre = 2;
        int prepre = 1;
        for (int i=3;i<=n;i++){
            res = pre+prepre;
            prepre = pre;
            pre = res;
        }
        return res;
    }


    public static void main(String[] args) {
        DpPractice01 dp1 = new DpPractice01();
        // System.out.println(dp1.climbLadder(6));
        // System.out.println(dp1.climbLadder1(6));
        System.out.println(dp1.climbLadder2(6));
    }

}
