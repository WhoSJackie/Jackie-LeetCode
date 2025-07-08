package com.wang.Leetcode.get_offer;

class NumMatrix {
    int[][] mat;
    public NumMatrix(int[][] matrix) {
        mat = new int[matrix.length][matrix[0].length+1];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                mat[i][j+1] = mat[i][j]+matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        // 进行矩阵的求和
        int count=0;
        for (int i=row1;i<=row2;i++){
            count+=(mat[i][col2+1]-mat[i][col1]);
        }
        return count;
    }
}
