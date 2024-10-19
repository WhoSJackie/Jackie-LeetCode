package com.wang.Leetcode;

public class No477 {

    // 1.暴力法，超时
    public int totalHammingDistance1(int[] nums) {
        int res=0;
        int len  =nums.length;
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                res+=hammingDistance(nums[i],nums[j]);
            }
        }
        return res;
    }

    private int hammingDistance(int x,int y){
        int cnt = 0;
        for (int i=x^y;i>0;i-=lowbits(i)){
            cnt++;
        }
        return cnt;
    }

    private int lowbits(int x){
        return x&(-x);
    }

    // 法二 乘法原则
    public int totalHammingDistance(int[] nums) {
        int res=0;
        int len  =nums.length;
        int[][] mat = new int[32][2];
        for (int i = 0; i < 32; i++) {
            // 统计所有数，每一位的1和0总个数
            for (int num : nums) {
                if (((num>>i)&1)==0) mat[i][0]++;
                else mat[i][1]++;
            }
            res+=mat[i][0]*mat[i][1];
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new No477().totalHammingDistance(new int[]{4, 14, 2}));
    }

}
