package com.wang.Leetcode.weekContest.week362;

import java.util.*;

public class No2848 {

    public int numberOfPoints(List<List<Integer>> nums) {
        // 法一 双重循环
        /**
        int len = nums.size();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < len; i++) {
            int s = nums.get(i).get(0);
            int e = nums.get(i).get(1);
            for (int j = s; j <= e; j++) {
                set.add(j);
            }
        }
        return set.size();
         **/

        // 法二 排序加区间合并法
        /**
        int len = nums.size();
        // 初始化
        nums.sort(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(0) - o2.get(0));
            }
        });
        // 创建新的合并队列
        List<int[]> tmp = new ArrayList<>();
        int s = nums.get(0).get(0);
        int e = nums.get(0).get(1);
        if (len==1) return e-s+1;
        int[] temp = new int[]{s,e};
        int res =(temp[1]-temp[0]+1);
        for (int i = 1; i < len; i++) {
            s = nums.get(i).get(0);
            e = nums.get(i).get(1);
            // 如果存在覆盖区间
            if (temp[0]<=s&&temp[1]>=s) {
                // 以免重复计算
                res-=(temp[1]-temp[0]+1);
                temp[0] = temp[0];
                temp[1] = Math.max(temp[1],e);
                res+=temp[1]-temp[0]+1;
            }  else{
                // 不存在覆盖区间
                res+=e-s+1;
                temp[0] = s;
                temp[1] = e;
            }
        }
        return res;
         **/

        // 法三 差分法
        int[] diff = new int[102];
        int res=0;
        // 求出差分数组
        for (List<Integer> num : nums) {
            diff[num.get(0)]++;
            diff[num.get(1)+1]--;
        }

        for (int i = 1; i < diff.length; i++) {
            diff[i]+=diff[i-1]+diff[i];
            if (diff[i]>0){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> que = new ArrayList<>();
        List<Integer> q1 = new ArrayList<>();
        q1.add(4);
        q1.add(4);
        List<Integer> q2 = new ArrayList<>();
        q2.add(9);
        q2.add(10);
        List<Integer> q3 = new ArrayList<>();
        q3.add(9);
        q3.add(10);
        List<Integer> q4 = new ArrayList<>();
        q4.add(3);
        q4.add(8);
        que.add(q1);
        que.add(q2);
        que.add(q3);
        que.add(q4);
        System.out.println(new No2848().numberOfPoints(que));
    }

}
