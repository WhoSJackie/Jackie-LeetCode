package com.wang.Leetcode.get_offer;

public class Inter13 {
    int res=0;
    int line;
    int col;
    int lim;
    boolean[][] vis;
    int[][] dic = {{1,0},{-1,0},{0,1},{0,-1}};
    public int movingCount(int m, int n, int k) {
        if (k==0) return 1;
        line = m;
        col = n;
        lim = k;
        vis = new boolean[line][col];
        dfs(0,0);
        return res;
    }

    public void dfs(int i,int j){
        if (i<0||i>=line||j<0||j>=col||(countNum(i)+countNum(j)>lim)||vis[i][j]) return;
        res++;
        vis[i][j] = true;
        dfs(i+1,j);
        dfs(i-1,j);
        dfs(i,j+1);
        dfs(i,j-1);
        vis[i][j] = false;
    }

    public int countNum(int i){
        int v=0;
        while (i!=0){
            v+=i%10;
            i = i/10;
        }
        return v;
    }

}
