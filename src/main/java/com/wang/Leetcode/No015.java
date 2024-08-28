package com.wang.Leetcode;

import java.util.*;

public class No015 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        // 对数组进行排序
        Arrays.sort(nums);
        // 相向双指针
        for (int i = 0; i < nums.length; i++) {
            int l = i+1;
            int r = nums.length-1;
            while (l<r){
                int sum = -(nums[l]+nums[r]);
                if (nums[i]==sum){
                    List<Integer> lis = Arrays.asList(nums[i],nums[l],nums[r]);
                    res.add(lis);
                    l++;
                    r--;
                } else if (nums[i]>sum){
                    r--;
                } else{
                    l++;
                }
            }
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        List<List<Integer>> res = new No015().threeSum(new int[]{3,0,-2,-1,1,2});
        for (List<Integer> re : res) {
            for (Integer integer : re) {
                System.out.println(integer);
            }
            System.out.println("--------------");
        }
    }

}
