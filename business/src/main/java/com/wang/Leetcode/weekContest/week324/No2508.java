package com.wang.Leetcode.weekContest.week324;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2508 {

    public boolean isPossible(int n, List<List<Integer>> edges) {
        // 转换为领接矩阵
        List<List<Integer>> arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (List<Integer> edge : edges) {
            arr.get(edge.get(0)).add(edge.get(1));
            arr.get(edge.get(1)).add(edge.get(0));
        }

        int[] cnt =new int[n+1];
        // 统计各节点的度数
        for (List<Integer> edge : edges) {
            cnt[edge.get(0)]++;
            cnt[edge.get(1)]++;
        }

        // 统计奇数的点
        List<Integer> oddPoint = new ArrayList<>();
        for (int i = 1; i < cnt.length; i++) {
            if (cnt[i]%2>0){
                oddPoint.add(i);
            }
        }

        if (oddPoint.size()>4||oddPoint.size()==1||oddPoint.size()==3) return false;
        if (oddPoint.size()<1) return true;

        // 剩下2,4个奇数点的情况
        // 讨论2这个情况
        if (oddPoint.size()==2){
            if (!arr.get(oddPoint.get(0)).contains(oddPoint.get(1))){
                return true;
            } else{
                // 如果奇点之间有边,必须找到一个能同时连接两个点的其他点
                for (int i = 1; i <= n; i++) {
                    if (i==oddPoint.get(0)||i==oddPoint.get(1)) continue;
                    if (!arr.get(i).contains(oddPoint.get(0))&&!arr.get(i).contains(oddPoint.get(1))) return true;
                }
            }
            return false;
        }

        // 讨论4这种情况
        // 统计连线的个数以及各点的度
        int a = oddPoint.get(0),b = oddPoint.get(1),c = oddPoint.get(2),d = oddPoint.get(3);
        return (!arr.get(a).contains(b)&&!arr.get(c).contains(d))||(!arr.get(a).contains(c)&&!arr.get(b).contains(d))
                ||(!arr.get(a).contains(d)&&!arr.get(b).contains(c));

    }

    public static void main(String[] args) {
        List<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(1,2));
        arr.add(Arrays.asList(2,3));
        arr.add(Arrays.asList(1,3));
        arr.add(Arrays.asList(4,1));
        arr.add(Arrays.asList(3,4));
        System.out.println(new No2508().isPossible(4, arr));
    }

}
