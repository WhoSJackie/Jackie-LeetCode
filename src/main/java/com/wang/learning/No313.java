package com.wang.learning;

public class No313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int len=primes.length;
        //结果数组
        int[] dp=new int[n];
        //每一个进度的下标数组
        int[] index=new int[len];
        //每一次进度的运算结果
        int[] res=new int[len];
        dp[0]=1;
        for (int i = 1; i < n;) {
            for (int i1 = 0; i1 < len; i1++) {
                res[i1]=dp[index[i1]] *primes[i1];
            }
            if(getMin(res)[0]!=dp[i-1]){
                dp[i]= getMin(res)[0];
                i++;
            }
            index[getMin(res)[1]]++;
        }

        return dp[n-1];
    }

    public int[] getMin(int[] nums){
        int[] res=new int[2];
        res[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(nums[i]<res[0]){
                res[0]=nums[i];
                res[1]=i;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        No313 n=new No313();
        int[] a={2,7,13,19};
        System.out.println(n.nthSuperUglyNumber(12, a));
    }
}
