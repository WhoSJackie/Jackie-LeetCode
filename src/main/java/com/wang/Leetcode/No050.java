package com.wang.Leetcode;

public class No050 {

    public double myPow(double x, int n) {
        long temp = Math.abs((long)n);
        double res = 1.0;
        double a = x;
        while (temp>0){
            if ((temp&1)==1){
                res*=a;
            }
            a*=a;
            temp=temp>>1;
        }
        return n<0?1/res:res;
    }

    // 递归法
    public double myPow1(double x, int n) {
        return n<0?1/dfs(x,-n):dfs(x,n);
    }

    private double dfs(double x,int n){
        if (n==0) return 1.0;
        double res = dfs(x,n/2);
        return n%2!=0?res*res*x:res*res;
    }


}
