package com.wang.Leetcode;

public class No1979 {

    public int findGCD(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 1.1找到最大和最小数
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            min = Math.min(nums[i],min);
            max = Math.max(nums[i],max);
        }
        // 1.2辗转相除法计算gcd
        int d = max;
        int r = min;
        while (r>1){
            int tmp = d%r;
            if (tmp==0) return r;
            d = r;
            r = tmp;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(new No1979().findGCD(new int[]{2,2,7}));
    }



}
