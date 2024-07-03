package com.wang.learning;

public class No326 {
    public static boolean isPowerOfThree(int n) {
       return  isThreePower(n);
    }

    public static boolean isThreePower(int n){
        if(n==1){
            return true;
        }
        if(n==0||n%3!=0){
            return false;
        }

        return isThreePower(n/3);
    }

    public static boolean isPowerOfThree1(int n) {
        if(n==1){
            return true;
        }
        int s=n/3;
        int r=n%3;
        while(s>1&&r==0){
          r=s%3;
          s=s/3;
        }
        return s==1&&r==0;
    }

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(27));
    }

}
