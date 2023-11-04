package com.wang.Leetcode.weekContest.week358;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class No2817 {

    public int minAbsoluteDifference(List<Integer> nums, int x) {
        // 直接遍历，最后三个用例超时
//        int res=Integer.MAX_VALUE;
//        for (int i = 0; i < nums.size(); i++) {
//            for (int j=i+x;j<nums.size();j++){
//                res = Math.min(res,Math.abs(nums.get(j)-nums.get(i)));
//            }
//        }
//        return res;

        // 使用treeset进行排序
        int res = Integer.MAX_VALUE;
        int len = nums.size();
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i=x;i<len;i++){
            int k = nums.get(i-x);
            treeSet.add(k);
            Integer ceiling = treeSet.ceiling(nums.get(i));
            if (ceiling!=null){
                res = Math.min(res,Math.abs(nums.get(i)-ceiling));
            }
            Integer floor = treeSet.floor(i);
            if (floor!=null){
                res = Math.min(res,Math.abs(nums.get(i)-floor));
            }
        }
        return res;
    }



    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();
        nums.add(4);
        nums.add(3);
        nums.add(2);
        nums.add(4);
        System.out.println(new No2817().minAbsoluteDifference(nums, 2));
    }

}
