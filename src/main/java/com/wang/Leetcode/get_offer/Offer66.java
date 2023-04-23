package com.wang.Leetcode.get_offer;

public class Offer66 {

    public int[] constructArr(int[] a) {
        int len  =a.length;
        // 从头到尾截止每个下标的乘积
        int[] pre = new int[len];
        pre[0] = a[0];
        int[] post = new int[len];
        int[] res = new int[len];
        post[len-1] = a[len-1];
        for (int i=1;i<len;i++){
            pre[i] = pre[i-1]*a[i];
        }

        // 从尾到头每个下标截止的乘积
        for (int i=len-2;i>=0;i--){
            post[i] = post[i+1]*a[i];
        }

        // 计算每个位置除当前下标的乘积
        res[0] = post[1];
        res[len-1] = pre[len-2];
        for (int i=1;i<len-1;i++){
            res[i] = pre[i-1]*post[i+1];
        }
        return res;
    }
}
