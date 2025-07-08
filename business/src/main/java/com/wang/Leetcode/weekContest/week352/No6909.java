package com.wang.Leetcode.weekContest.week352;

public class No6909 {

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int len = nums.length;
        int l=0;
        int r;
        int max=0;
        for (r=len-1;r>=0;r--){
            l=0;
            while (l<=r){
                if (nums[l]%2==0){
                    // 验证数组是否满足条件
                    if (validArr(nums,l,r,threshold)) {
                        max = Math.max(max,r-l+1);
                    }
                }
                l++;
            }
        }
        return max;
    }

    public boolean validArr(int[]arr,int l,int r,int threshold){
        for (int i=l;i<r;i++){
            if (arr[i]>threshold) return false;
            if (arr[i]%2==arr[i+1]%2) return false;
        }
        return arr[r]<=threshold;
    }

    public static void main(String[] args) {
        System.out.println(new No6909().longestAlternatingSubarray(new int[]{2,3,3,10}, 18));
    }


}
