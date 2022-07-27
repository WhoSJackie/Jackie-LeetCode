package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1260 {

    private int m;
    private int n;

    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int x=k;
        List<List<Integer>> res = new ArrayList<>();
        if (grid==null||grid.length<=0||grid[0].length<=0){
            return res;
        }
        m = grid.length;;
        n = grid[0].length;

//        while(x>0){
//            getMove(grid);
//            x--;
//        }

        // *************************
        // 法2
        int[][] arr = new int[m][n];
        for (int i = 0; i < n; i++) {
            int tcol = (i+k)%n;
            // 每列首行行下标
            int trow = ((i+k)/n)%m;
            int cnt = 0;
            while(cnt<m){
                arr[(trow++)%m][tcol] = grid[cnt++][i];
            }
        }

        // *************************

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }
            res.add(row);
        }
        return res;

    }

//    private void getMove(int[][] grid){
//        int temp = grid[m-1][n-1];
//        for (int i=m-1;i>=0;i--){
//            for (int j=n-2;j>=0;j--){
//                grid[i][j+1] = grid[i][j];
//            }
//            if (i!=0){
//                grid[i][0] = grid[i-1][n-1];
//            }
//        }
//        grid[0][0] = temp;
//    }

}
