package com.wang.Leetcode;

import java.util.*;

public class No018 {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        Set<List<Integer>> res = new HashSet<>();
        // 排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-3; i++) {
            // 进行第一层剪枝
            long x= nums[i];
            if (i>0 && nums[i] == nums[i-1]) continue;// 跳过重复值
            if (x+nums[i+1]+nums[i+2]+nums[i+3]>target) break;// 当前以nums[i]开头的循环最小值仍然大于target，则直接跳出
            if (x+nums[len-3]+nums[len-2]+nums[len-1]<target) continue;// 当前以nums[i]开头的循环最大值仍然小于target，则跳过以nums[i]为开头的循环
            for (int j = i+1; j < nums.length-2; j++) {
                // 进行第二层剪枝
                long y = nums[j];
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                if (x+y+nums[j+1]+nums[j+2]>target) break;// 当前以nums[j]开头的循环最小值仍然大于target，则直接跳出
                if (x+y+nums[len-2]+nums[len-1]<target) continue;// 当前以nums[j]开头的循环最大值仍然小于target，则跳过以nums[i]为开头的循环
                int l = j+1;
                int r = nums.length-1;
                long tar = (long) target -x-y;
                while (l<r){
                    if (tar == nums[l]+nums[r]){
                        res.add(Arrays.asList(nums[i],nums[j],nums[l],nums[r]));
                        for (l++;l<r&&nums[l]==nums[l-1];l++);// 跳过重复元素
                        for (r--;l<r&&nums[r]==nums[r+1];r--);
                    } else if (tar > nums[l]+nums[r]){
                        l++;
                    } else{
                        r--;
                    }
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        // List<List<Integer>> res = new No018().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296);
        List<List<Integer>> res = new No018().fourSum(new int[]{1,0,-1,0,-2,2},0);
        for (List<Integer> re : res) {
            for (Integer in : re) {
                System.out.print(in);
                System.out.print(",");
            }
            System.out.println();
            System.out.println("---------");
        }
    }



}
