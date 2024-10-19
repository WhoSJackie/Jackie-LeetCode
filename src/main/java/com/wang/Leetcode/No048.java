package com.wang.Leetcode;

public class No048 {

    public void rotate(int[][] matrix) {
        // 对矩阵先按照主对角线进行元素交换
        int len = matrix.length;
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i-1; j++) {
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        // 对左右对称的列进行交换
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len/2; j++) {
                int temp = matrix[i][len-j-1];
                matrix[i][len-j-1] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

    }

    public static void main(String[] args) {
        new No048().rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }

}
