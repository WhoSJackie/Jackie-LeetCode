package com.wang.Leetcode;

public class No172 {

    public int trailingZeroes(int n) {
        return n==0?0:n/5+trailingZeroes(n/5);
    }

    public static void main(String[] args) {
        System.out.println(new No172().trailingZeroes(6));
    }

}
