package com.wang.learning;

public class No1252 {
    public int oddCells(int m, int n, int[][] indices) {
        int[][] res = new int[m][n];

        for (int i = 0; i < indices.length; i++) {
            handleMatrix(res,indices[i][0],indices[i][1]);
        }
        int count=0;
        for (int i = 0; i < m; i++) {
            for (int i1 = 0; i1 < n; i1++) {
                if (res[i][i1]%2!=0){
                    count++;
                }
            }
        }

        return count;

    }

    private void handleMatrix(int[][] handle,int x,int y){
        if (x>handle.length||y>handle[0].length){
            return;
        }
        for (int i = 0; i < handle[x].length; i++) {
            handle[x][i]++;
        }

        for (int j=0;j<handle.length;j++){
            handle[j][y]++;
        }
    }
}
