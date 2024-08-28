package com.wang.Leetcode;


import java.util.HashMap;
import java.util.Map;

public class No454 {
    int res;
    // 法一 dfs超时
    public int fourSumCount1(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        dfs(0,nums1,nums2,nums3,nums4,0);
        return res;
    }

    private void dfs(int depth,int[] nums1,int[] nums2,int[] nums3,int[] nums4,int sum){
        if (depth==4){
            if (sum==0) res++;
            return;
        }
        int[] nums=null;
        switch(depth){
            case 0:nums = nums1;
                   break;
            case 1:nums = nums2;
                   break;
            case 2:nums = nums3;
                   break;
            case 3:nums = nums4;
            default:
        }
        for (int i = 0; i < nums.length; i++) {
            dfs(depth+1,nums1,nums2,nums3,nums4,sum+nums[i]);
        }

    }

    // 法二 hash表
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        int len = nums1.length;
        Map<Integer,Integer> map = new HashMap<>();
        // 放入hash表
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                map.put(nums1[i]+nums2[j],map.getOrDefault(nums1[i]+nums2[j],0)+1);
            }
        }
        //开始遍历nums3和nums4
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (map.get(-nums3[i]-nums4[j])!=null) {
                    res+=map.get(-nums3[i]-nums4[j]);
                }
            }
        }
        return res;
    }

}
