package com.wang.Leetcode.weekContest.week324;

public class No2507 {

    public int smallestValue(int n) {
        int cnt;
        while (!isPrime(n)){
            cnt=0;
            // 计算质因数的和
            int i=2;
            while (n>=i){
                if (n==i){
                    cnt+=n;
                    break;
                } else if (n%i==0){
                    cnt+=i;
                    n/=i;
                } else{
                    i++;
                }
            }
            n = cnt;
        }
        return n;
    }

    public boolean isPrime(int n){
        if (n==2|n==3){
            return true;
        }

        if (n%2==0) return false;

        for (int i=3;i<=Math.sqrt(n);i=i+2){
            if (n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No2507().smallestValue(9));
    }

}
