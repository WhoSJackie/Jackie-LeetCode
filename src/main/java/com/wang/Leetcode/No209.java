package com.wang.Leetcode;

public class No209 {

    public int minSubArrayLen(int target, int[] nums) {
        // 法一 遍历右边界法
//        int len = nums.length;
//        int l=0;
//        int cnt=Integer.MAX_VALUE;
//        int sum=0;
//        for (int r=0;r<len;r++){
//            sum+=nums[r];
//            while (sum>=target){
//                cnt = Math.min(cnt,r-l+1);
//                sum-=nums[l++];
//            }
//        }
//        return cnt==Integer.MAX_VALUE?0:cnt;

        // 法二 普通滑动窗口法
        int len = nums.length;
        int l=0;
        int r=0;
        int res=len+1;
        int sum=nums[l];
        while (l<=r&&r<len){
            while (sum<target){
                r++;
                if (r>=len) break;
                sum+=nums[r];
            }

            while (sum>=target){
                res = Math.min(res,r-l+1);
                sum-=nums[l];
                l++;
            }

        }
        return res==len+1?0:res;
    }

}
