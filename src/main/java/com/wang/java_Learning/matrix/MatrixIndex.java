package com.wang.java_Learning.matrix;

public class MatrixIndex {

    public int[] twoDimensionToOneDimension(int[][] mat){
        int n = mat.length;
        int m = mat[0].length;
        int muti = Math.max(m, n);
        int[] res = new int[m*n];
        for (int i=0;i<n;i++){
            for (int j=0;j<m;j++){
                res[i*m+j] = mat[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new MatrixIndex().twoDimensionToOneDimension(new int[][]{{1, 2, 3,5}, {4, 5, 6,7}, {7, 8, 9,10}});
        for (int re : res) {
            System.out.println(re);
        }
    }


}
