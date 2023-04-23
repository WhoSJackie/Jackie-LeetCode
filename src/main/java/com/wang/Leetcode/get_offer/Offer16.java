package com.wang.Leetcode.get_offer;

public class Offer16 {

    public double myPow(double x, int n) {
        if (x==1) return 1;
        long tempn = n;
        boolean flag = false;
        if (tempn<0){
            tempn = -tempn;
            flag = true;
        }
        double res = 1;
        while (tempn>0){
            res*=x;
            tempn--;
        }

        return flag?1/res:res;
    }


}
