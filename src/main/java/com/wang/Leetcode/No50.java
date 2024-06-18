package com.wang.Leetcode;

public class No50 {

    public double myPow(double x, int n) {
        if (Math.abs(x)!=1&&n==Integer.MIN_VALUE) return 0;
        double res=1.0;
        long temp = Math.abs((long)n);
        for (;temp>0;temp/=2){
            if (temp%2>0){
                res = res*x;
            }
            x = x*x;
        }
        return n<0?1/res:res;
    }

}
