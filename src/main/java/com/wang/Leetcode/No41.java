package com.wang.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No41 {
    // 不符合空间复杂度O(1)
    public int firstMissingPositive1(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,nums[i]);
            map.putIfAbsent(nums[i],1);
        }
        if (max<0) return 1;
        for (int i = 1; i <= max; i++) {
            if (map.get(i)==null) return i;
        }
        return max+1;

    }

    //
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        // 先将负数置为n+1
        for (int i = 0; i < n; i++) {
            nums[i] = nums[i]<=0?n+1:nums[i];
        }
        // 将数据的绝对值在[1,n]范围的对应位置-1的位置的数上个负号
        for (int i = 0; i < n; i++) {
            if (nums[i]==n+1) continue;
            int abs = Math.abs(nums[i]);
            if (abs>=1 && abs<=n) nums[abs-1] = -Math.abs(nums[abs-1]);
        }
        // 如果全部为n+1那么就是1，如果不是，找到没有负号的最小位置
        for (int i = 0; i < n; i++) {
            if (nums[i]>0 || nums[i]==n+1) return i+1;
        }
        return n+1;
    }

    public static void main(String[] args) {
        System.out.println(new No41().firstMissingPositive(new int[]{-1,-2}));
    }
}
