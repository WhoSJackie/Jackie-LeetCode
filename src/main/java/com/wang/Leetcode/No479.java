package com.wang.Leetcode;

public class No479 {

    public int largestPalindrome(int n) {
        if (n==1) return 9;
        // 总是能够从2*n位数的数中枚举出答案
        int max = (int)Math.pow(10,n)-1;
        // 枚举前半部分即可，后半部分保持一致
        for (int i=max;i>=0;i--){
            long num = i,t = i;
            // 构造num
            while (t!=0){
                num  = num*10+(t%10);
                t/=10;
            }
            // 找到该数是否能被分解成两个n位因子
            for (long j = max;  j *j>=num; j--){
                if (num%j==0) return (int)(num%1337);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new No479().largestPalindrome(5));
    }

}
