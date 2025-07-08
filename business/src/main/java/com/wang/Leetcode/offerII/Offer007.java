package com.wang.Leetcode.offerII;

import java.util.*;

public class Offer007 {

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> res = new LinkedHashSet<>();
        Arrays.sort(nums);
        for (int i=0;i<nums.length-2;i++){
            int head = i+1;
            int tail = nums.length-1;
            while (head<tail){
                int tar = -(nums[head]+nums[tail]);
                if (tar==nums[i]){
                    res.add(Arrays.asList(nums[head],nums[tail],nums[i]));
                }
                if (tar>=nums[i]){
                    head++;
                } else{
                    tail--;
                }
            }
        }
        return new ArrayList<>(res);
    }


    public static void main(String[] args) {
       List<List<Integer>> res =  new Offer007().threeSum(new int[]{-1,0,1,2,-1,-4});
        for (List<Integer> re : res) {
            for (Integer i : re) {
                System.out.println(i);
            }
            System.out.println();
        }
    }

}
