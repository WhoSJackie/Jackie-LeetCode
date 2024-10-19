package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No046 {

    List<List<Integer>> res;
    List<Integer> tmp;
    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        int len  =nums.length;
        boolean[] vis = new boolean[len];
        tmp = new ArrayList<>();
        backTrace(nums,0,vis);
        return res;
    }

    private void backTrace(int[] nums,int n,boolean[] vis){
        if (n==nums.length){
            res.add(new ArrayList<>(tmp));
        }
        for (int i=0;i<nums.length;i++){
            if (vis[i]) continue;
            vis[i] = true;
            tmp.add(nums[i]);
            backTrace(nums,n+1,vis);
            // 还原现场
            tmp.remove(tmp.size()-1);
            vis[i] = false;
        }

    }

}
