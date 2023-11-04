package com.wang.Leetcode.weekContest.week358;

public class No2815 {

    public int maxSum(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int solution = -1;
        // 找到到每一个数字的位数中最大数
        for (int i = 0; i < len; i++) {
            res[i] = maxPos(nums[i]);
        }
        // 遍历进行最大和
        for (int i = 0; i < len; i++) {
            for (int j = i+1; j < len; j++) {
                if (res[i]==res[j]){
                    solution = Math.max(solution,nums[i]+nums[j]);
                }
            }
        }
        return solution;
    }

    private int maxPos(int num){
        int res=-1;
        while (num>0){
            res = Math.max(res,num%10);
            num = num/10;
        }
        return res;
    }



}
