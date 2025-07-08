package com.wang.Leetcode.weekContest.week353;

import java.util.Arrays;

public class No2771 {
    // 法一 dfs超时
//    public int res;
//    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
//        res=0;
//        dfs(nums1,nums2,0,0,0);
//        return res;
//    }
//
//
//    private void dfs(int[] nums1,int[] nums2,int index,int preChoose,int curRes){
//        if (index==nums1.length){
//            return;
//        }
//        boolean flag=false;
//        int tmpCurRes=curRes;
//        if (nums1[index]>=preChoose) {
//            curRes++;
//            res = Math.max(res,curRes);
//        } else {
//            curRes=1;
//        }
//        dfs(nums1,nums2,index+1,nums1[index],curRes);
//        curRes = tmpCurRes;
//        if (nums2[index]>=preChoose){
//            curRes++;
//            res = Math.max(res,curRes);
//        } else{
//            curRes=1;
//        }
//        dfs(nums1,nums2,index+1,nums2[index],curRes);
//        curRes = flag?curRes-1:curRes;
//    }

    // 法二 动态规划
//    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
//        int len = nums1.length;
//        int [] dp1 = new int[len];
//        int[] dp2 = new int[len];
//        Arrays.fill(dp1,1);
//        Arrays.fill(dp2,1);
//        int res=1;
//        for (int i=1;i<len;i++){
//            // 这次选择nums1
//            // 上一次结尾是nums1
//            if (nums1[i]>=nums1[i-1]){
//                dp1[i] = Math.max(dp1[i],dp1[i-1]+1);
//            }
//            // 上一次结尾是nums2
//            if (nums1[i]>=nums2[i-1]){
//                dp1[i] = Math.max(dp1[i],dp2[i-1]+1);
//            }
//
//            // 本次选择nums2
//            // 上一次结尾是nums1
//            if (nums2[i]>=nums1[i-1]){
//                dp2[i] = Math.max(dp2[i],dp1[i-1]+1);
//            }
//            // 上一次结尾是nums2
//            if (nums2[i]>=nums2[i-1]){
//                dp2[i] = Math.max(dp2[i],dp2[i-1]+1);
//            }
//            res = Math.max(Math.max(dp1[i],dp2[i]),res);
//        }
//        return res;
//    }

    public int maxNonDecreasingLength(int[] nums1, int[] nums2) {
        int len = nums1.length;
        int [][] dp = new int[len][2];
        for (int i = 0; i < dp.length; i++) {
            for (int i1 = 0; i1 < dp[i].length; i1++) {
                dp[i][i1] = 1;
            }
        }
        int res=1;
        for (int i=1;i<len;i++){
            // 这次选择nums1
            // 上一次结尾是nums1
            if (nums1[i]>=nums1[i-1]){
                dp[i][0] = Math.max(dp[i][0],dp[i-1][0]+1);
            }
            // 上一次结尾是nums2
            if (nums1[i]>=nums2[i-1]){
                dp[i][0] = Math.max(dp[i][0],dp[i-1][1]+1);
            }

            // 本次选择nums2
            // 上一次结尾是nums1
            if (nums2[i]>=nums1[i-1]){
                dp[i][1] = Math.max(dp[i][1],dp[i-1][0]+1);
            }
            // 上一次结尾是nums2
            if (nums2[i]>=nums2[i-1]){
                dp[i][1] = Math.max(dp[i][1],dp[i-1][1]+1);
            }
            res = Math.max(Math.max(dp[i][0],dp[i][1]),res);
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{2,3,1};
        int[] nums2 = new int[]{1,2,1};
        System.out.println(new No2771().maxNonDecreasingLength(nums1, nums2));
    }
}
