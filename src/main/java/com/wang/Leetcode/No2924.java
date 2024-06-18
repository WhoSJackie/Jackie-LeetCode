package com.wang.Leetcode;

public class No2924 {
    // 方法1 dfs有向图
    public int[][] matrix;
    public int findChampion(int n, int[][] edges) {
        matrix = new int[n][n];
        // 进行领接矩阵的构建
        for (int i = 0; i < edges.length; i++) {
            // 强队比弱队为1；相反为-1
            matrix[edges[i][0]][edges[i][1]] = 1;
            matrix[edges[i][1]][edges[i][0]] = -1;
        }
        boolean[] vis = new boolean[n];
        // 进行冠军的筛选
        int count=0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=j&&matrix[i][j]==1&&!vis[j]){
                    count+=dfs(i,j,n,vis);
                }
            }
            if (count==n-1) return i;
            // 重置
            for (int i1 = 0; i1 < n; i1++) {
                vis[i1] = false;
            }
            count=0;
        }
        return -1;
    }

    private int dfs(int i,int j,int n,boolean[] vis){
        if (i>=n||j>=n) return 0;
        int x=0;
        if (matrix[i][j]==1){
            vis[j] = true;
            x=1;
        }
        for (int i1 = 0; i1 < n; i1++) {
            if (matrix[j][i1]==1&&!vis[i1]){
                x+=dfs(j,i1,n,vis);
            }
        }
        return x;
    }

    // 方法2 通过入度计算胜队
    public int findChampion1(int n, int[][] edges) {
        int[] temp = new int[n];
        // 对每一队入度进行计数
        for (int[] edge : edges) {
            temp[edge[1]]++;
        }
        int count=0;
        int res = -1;
        // 统计没有入度的队
        for (int i = 0; i < temp.length; i++) {
            if (temp[i]<=0){
                res = i;
                count++;
                // 如果超过一个队入度等于0，则结果为-1，没有冠军
                if (count>1){
                    res = -1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No2924().findChampion(3, new int[][]{{0, 1}, {0, 2}, {1, 2}}));
    }

}
