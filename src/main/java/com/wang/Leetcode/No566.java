package com.wang.Leetcode;

public class No566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length;
        int col = mat[0].length;
        int x=0;
        int y=0;
        if (row*col!=r*c || r==0 || c==0) return mat;
        int[][] newMat = new int[r][c];
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                newMat[x][y++] = mat[i][j];
                if (y>=c) {
                    x++;
                    y=0;
                }
            }
        }
        return newMat;
    }

    public static void main(String[] args) {
        new No566().matrixReshape(new int[][]{{1,2},{3,4}},1,4);
    }

}
