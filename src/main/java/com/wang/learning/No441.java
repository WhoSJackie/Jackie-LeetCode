package com.wang.learning;

public class No441 {

    public int arrangeCoins(int n) {
        int index=1;
        while(n>0){
            n-=index;
            index++;
        }
        return n==0?index-1:index-2;
    }

    //二分法查找目标数下标
    public int halfsort(int a){
        int l=1;
        int r=a;
        while(l<=r){
            int mid=l+(r-l)/2;
            if((long) mid*(mid+1)==(long)2*a){
                return mid;
            }
            else if((long) mid*(mid+1)<(long)2*a){
                l=mid+1;
            }
            else{
                r=mid-1;
            }
        }
        return r;
    }

    public static void main(String[] args) {
//        System.out.println(new No441().arrangeCoins(5));
        System.out.println(new No441().halfsort(2));
    }
}
