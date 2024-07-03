package com.wang.learning;

public class No367 {
    public boolean isPerfectSquare(int num) {
        //1.暴力法
//        int temp=num/2;
//        if(num==1){
//           temp=1;
//        }
//        for (int i = 1; i <= temp; i++) {
//            if(i*i==num){
//                return true;
//            }
//        }
//        return false;

        //2.二分法
        int i=0;
        int j=num;
        int mid=0;
        while(i<=j){
            mid=i+(j-i)/2;
            long sum=(long)mid*mid;
           if(sum==num){
               return true;
           }
           else if(sum>num){
               j=mid-1;
           }
           else{
               i=mid+1;
           }

        }

        return false;

    }

    public static void main(String[] args) {
        System.out.println(new No367().isPerfectSquare(2147483647));
    }
}
