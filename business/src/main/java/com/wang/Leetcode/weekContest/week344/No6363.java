package com.wang.Leetcode.weekContest.week344;

import java.util.ArrayList;
import java.util.List;

public class No6363 {

    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int cnt = nums.length;
        while (cnt>0){
            List<Integer> r = new ArrayList<>();
            for (int i=0;i<nums.length;i++){
                if (nums[i]==-1||r.contains(nums[i])){
                    continue;
                } else{
                    r.add(nums[i]);
                    cnt--;
                    nums[i]=-1;
                }
            }
            res.add(r);
        }
        return res;

    }

}
