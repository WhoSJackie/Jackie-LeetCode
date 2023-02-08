package com.wang.Leetcode.weekContest.week323;

import java.util.Arrays;

public class No2500 {

    public int deleteGreatestValue(int[][] grid) {
        int max = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = 0; i < grid.length; i++){
            Arrays.sort(grid[i]);
        }

        for (int j = 0; j < grid[0].length; j++) {
            for (int i = 0; i < grid.length; i++){
                max = Math.max(max,grid[i][j]);
            }
            // sum求和
            sum+=max;
            max = Integer.MIN_VALUE;
        }
        return sum;
    }

    public static void main(String[] args) {
        int res = new No2500().deleteGreatestValue(new int[][]{{1,2,4},{3,3,1}});
        System.out.println(res);
    }

}
