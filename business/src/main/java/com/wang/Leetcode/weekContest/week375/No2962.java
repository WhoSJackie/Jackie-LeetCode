package com.wang.Leetcode.weekContest.week375;

public class No2962 {

    public long countSubarrays(int[] nums,int k){
        // 找出最大的元素
        long res=0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]>max) max = nums[i];
        }

        // 滑动窗口
        int cnt=0;
        int left=0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i]==max) {
                cnt++;
            }
            while (cnt == k) {
                // 当前计数数量等于目标数量，开始收缩左边界直到cnt<K
                if (nums[left++]==max){
                    cnt--;
                }
            }
            res+=left;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No2962().countSubarrays(new int[]{61,23,38,23,56,40,82,56,82,82,82,70,8,69,8,7,19,14,58,42,82,10,82,78,15,82}, 2));
    }

}
