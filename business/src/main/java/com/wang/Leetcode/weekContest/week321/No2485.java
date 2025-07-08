package com.wang.Leetcode.weekContest.week321;

public class No2485 {

    public int pivotInteger(int n) {
        int l = 1;
        int r = n;
        int mid;
        while (l<=r){
            mid = l+(r-l)/2;
            int left = (1+mid)*mid/2;
            int right = (mid+n)*(n-mid+1)/2;
            if (left==right){
                return mid;
            } else if(left>right){
                r = mid-1;
            } else{
                l = mid+1;
            }
        }
        return ((1+l)*l/2)==((l+n)*(n-l)/2)?l:-1;
    }

    public static void main(String[] args) {
        System.out.println(new No2485().pivotInteger(8));
    }

}
