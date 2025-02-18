package com.wang.learning;

public class No289 {

    private static int[][] dirs = new int[][]{{0,1},{0,-1},{1,1},{1,0},{-1,0},{-1,-1},{-1,1},{1,-1}};
    public void gameOfLife(int[][] board) {
        int col = board.length;
        int row = board[0].length;
        int[][] dup = new int[col][row];
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                dup[i][j] = board[i][j];
            }
        }
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                board[i][j] = setCellStatus(i,j,dup);
            }
        }
    }

    private int setCellStatus(int i,int j,int[][] dup){
        int zero=0,one=0;
        for (int[] dir : dirs) {
            int row = i+dir[0];
            int col = j+dir[1];
            if (row<0 || row>=dup.length || col<0 || col>=dup[0].length) continue;
            if (dup[row][col]==0) zero++;
            else one++;
        }
        int status = dup[i][j];
        if (status==0){
            if (one==3) status = 1;
        }else {
            if (one>3 || one<2) status = 0;
        }
        return status;
    }

}
