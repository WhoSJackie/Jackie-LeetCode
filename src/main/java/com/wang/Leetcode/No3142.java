package com.wang.Leetcode;

public class No3142 {

    public boolean satisfiesConditions(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i<row-1 && grid[i][j]!=grid[i+1][j]) return false;
                if (j+1<col && grid[i][j]==grid[i][j+1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No3142().satisfiesConditions(new int[][]{{1}, {2}, {3}}));
    }


}
