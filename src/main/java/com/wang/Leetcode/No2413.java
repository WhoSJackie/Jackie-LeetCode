package com.wang.Leetcode;

public class No2413 {

    public int smallestEvenMultiple(int n) {
        // 求出最大公约数
        int a = Math.max(2,n);
        int b = Math.min(2,n);
        int tmp = 0;
        while (b!=0){
            tmp = b;
            b = a%b;
            a = tmp;
        }
        return 2*n/a;
    }

    public static void main(String[] args) {
        System.out.println(new No2413().smallestEvenMultiple(6));
    }

}
