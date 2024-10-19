package com.wang.Leetcode;

import java.util.*;

public class No056 {

    public int[][] merge(int[][] intervals) {
        int len = intervals.length;
        Deque<int[]> res = new LinkedList<>();
        Arrays.sort(intervals, (o1, o2) -> Integer.compare(o1[1] - o2[1], 0));
        int curS = intervals[len-1][0];
        int curE = intervals[len-1][1];
        // 进行区间合并
        for (int i = len-2; i >=0; i--) {
            int s = intervals[i][0];
            int e = intervals[i][1];
            if (e>=curS){
                // 拓展当前区间
                if (s<curS){
                    curS = s;
                }
            } else{
                // 没有交集
                   res.push(new int[]{curS,curE});
                   curS = s;
                   curE = e;
            }
        }
        // 处理最后一个区间
        if (res.isEmpty() || res.peek()[0]!=curS){
            res.push(new int[]{curS,curE});
        }
        int[][] r = new int[res.size()][2];
        int ix=0;
        while (!res.isEmpty()) {
            int[] tmp = res.poll();
            r[ix][0] = tmp[0];
            r[ix][1] = tmp[1];
            ix++;
        }
        return r;
    }
    public int[][] merge1(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]); // 按照左端点从小到大排序
        List<int[]> ans = new ArrayList<>();
        for (int[] p : intervals) {
            int m = ans.size();
            if (m > 0 && p[0] <= ans.get(m - 1)[1]) { // 可以合并
                ans.get(m - 1)[1] = Math.max(ans.get(m - 1)[1], p[1]); // 更新右端点最大值
            } else { // 不相交，无法合并
                ans.add(p); // 新的合并区间
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }


    public static void main(String[] args) {
        int[][] res = new No056().merge(new int[][]{{1,4},{4,5}});
        for (int[] re : res) {
            for (int i : re) {
                System.out.println(i);
            }
            System.out.println("----------");
        }
    }

}
