package com.wang.Leetcode.get_offer;

public class Offer04 {
    int[][] direction = {{1,0},{0,1}};
    int[][] mat;
    int tar;
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length<=0||matrix[0].length<=0) return false;
        mat = matrix;
        tar = target;
        return dfs(0,0);
    }

    public boolean dfs(int x,int y){
        if (x<0||x>=mat.length||y<0||y>=mat[0].length){
            return false;
        }

        if (mat[x][y] == tar) return true;
        boolean flag = false;
        for (int[] dir : direction) {
            flag = flag||dfs(x+dir[0],y+dir[1]);
        }
        return flag;
    }

    public boolean findNumberIn2DArray1(int[][] matrix, int target) {
        if (matrix.length<=0||matrix[0].length<=0) return false;
        mat = matrix;
        int n=mat.length;
        int m = mat[0].length;
        int i=0;
        int j = m-1;
        while (i<n&&j>=0&&j<m){
            if (mat[i][j]==target) return true;
            if (i>=0&&i<n&&j>=0&&j<m&&mat[i][j]<target) i++;
            if (i>=0&&i<n&&j>=0&&j<m&&mat[i][j]>target) j--;
        }
        return false;
    }

}
