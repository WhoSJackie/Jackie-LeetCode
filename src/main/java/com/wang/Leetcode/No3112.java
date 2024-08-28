package com.wang.Leetcode;

import java.util.*;

public class No3112 {

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int[] res = new int[n];
        Arrays.fill(res,-1);
        // 建立邻接矩阵
        List<int[]>[] mat = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mat[i] = new ArrayList<>();
        }
        // 使用堆找到每一迭代最短的边,放置u中的点到0的距离
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[0]-b[0]);
        // 初始化邻接矩阵
        for (int i = 0; i < edges.length; i++) {
            int s = edges[i][0],e = edges[i][1],len = edges[i][2];
            mat[s].add(new int[]{e,len});
            mat[e].add(new int[]{s,len});
        }
        pq.offer(new int[]{0,0});
        res[0] = 0;
        // 更新最短路
        while (!pq.isEmpty()){
            int[] p = pq.poll();
            int t = p[0];
            int len = p[1];
            // 为了排除重复加入不是最短边的情况
            if (res[t]!=len) continue;
            // 新出队的节点串联其他u中的点
            for (int[] e: mat[t]) {
                int v = e[0],l = e[1];
                int length = len+l;
                if (length<disappear[v] && (res[v]==-1 || length<res[v])){
                    pq.offer(new int[]{v,length});
                    res[v] = length;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = new int[][]{{0,1,2},{1,2,1},{0,2,4}};
        int[] disappear = new int[]{1,3,5};
        int[] res = new No3112().minimumTime(n,edges,disappear);
        for (int re : res) {
            System.out.println(re);
        }
    }

}
