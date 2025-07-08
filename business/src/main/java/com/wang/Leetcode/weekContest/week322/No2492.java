package com.wang.Leetcode.weekContest.week322;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class No2492 {
    int res = Integer.MAX_VALUE;
    List<int[]>[] edge;
    int[] parent;
    public int minScore(int n, int[][] roads) {
        edge = new List[n+1];
        // 初始化
        for (int i = 0; i < edge.length; i++) {
            edge[i] = new ArrayList<>();
        }
        for (int[] road : roads) {
            edge[road[0]].add(new int[]{road[1],road[2]});
            edge[road[1]].add(new int[]{road[0],road[2]});
        }
        parent = new int[n+1];
        // 初始化parent数组
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <=n; i++) {
            if ( (find(i)==1) && edge[i].size()>0){
                edge[i].sort(new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return o1[1]-o2[1];
                    }
                });
                res = Math.min(res,edge[i].get(0)[1]);
            }
        }
        return res;
    }

    private int find(int i){
        while (i!=parent[i]){
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    private void merge(int i,int j){
        int parenti = find(i);
        int parentj = find(j);
        if (parenti<=parentj){
            parent[parentj] = parenti;
        } else{
            parent[parenti] = parentj;
        }
    }

    public static void main(String[] args) {
        int res = new No2492().minScore(4,new int[][]{{1,2,9},{2,3,6},{2,4,5},{1,4,7}});
        System.out.println(res);
    }

}
