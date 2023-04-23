package com.wang.Leetcode.get_offer;

public class Offer53 {

    public int search(int[] nums, int target) {
        if (nums.length<=0) return 0;
        int i=0;
        int j=nums.length-1;
        int count=0;
        while (i<j){
            if (nums[i++]==target) count++;
            if (nums[j--]==target) count++;
        }
        if (i==j&&nums[i]==target) count++;
        return count;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,5,5,8,8,7};
        System.out.println(new Offer53().search(nums, 8));
    }

}
