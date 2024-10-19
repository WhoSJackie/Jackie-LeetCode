package com.wang.Leetcode;

public class No059 {

    public int[][] generateMatrix(int n) {
        // 创建初始化矩阵
        int[][] mat = new int[n][n];
        int x = 0,y=0;
        int ix = 1;
        while (ix<=n*n){
            // 先进行横向运动，遇到边界转向
            while (y<n && mat[x][y]==0){
                mat[x][y++] = ix++;
            }
            y--;
            x++;
            // 转向南
            while (x<n && mat[x][y]==0){
                mat[x++][y] = ix++;
            }
            x--;
            y--;
            // 转向西
            while (y>=0 && mat[x][y]==0){
                mat[x][y--] = ix++;
            }
            y++;
            x--;
            // 转向北
            while (x>=0 && mat[x][y]==0){
                mat[x--][y] = ix++;
            }
            x++;
            y++;
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] matrix = new No059().generateMatrix(3);
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j]);
                System.out.print("-");
            }
            System.out.println("");
        }
    }


}
