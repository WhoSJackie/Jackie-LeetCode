package com.wang.Leetcode.weekContest.week322;

public class No2492_1 {
    private int res = Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        UnionFind uf = new UnionFind(n);
        for (int i = 0; i < n; i++) {
           uf.add(i);
        }

        for (int[] road : roads) {
            uf.union(road[0]-1,road[1]-1);
        }

        for (int[] road : roads) {
            int vertex = road[0]-1;
            if (uf.isConnected(0,vertex)){
                res = Math.min(res,road[2]);
            }
        }
        return res;
    }



}

class UnionFind{

    private int num;
    private int[] parent;

    public UnionFind(int n){
        num = 0;
        parent = new int[n];
    }

    public void add(int i){
        num++;
        parent[i] = i;
    }

    public int find(int i){
        while (i!=parent[i]){
            i = parent[i];
            parent[i] = parent[parent[i]];
        }
        return i;
    }

    public void union(int i,int j){
        int parenti = find(i);
        int parentj = find(j);
        if (parenti<=parentj){
            parent[parentj] = parenti;
        } else{
            parent[parenti] = parentj;
        }
    }

    public boolean isConnected(int i,int j){
        return find(i)==find(j);
    }

}
