package com.wang.learning;

import java.util.Arrays;

public class No1034 {
    int[][] direction={{0,-1},{0,1},{1,0},{-1,0}};
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        boolean[][] visit=new boolean[grid.length][grid[0].length];
        boolean[][] laser=new boolean[grid.length][grid[0].length];
        // true代表涂色
        dfs(grid,visit,laser,row,col,grid[row][col]);

        for (int i = 0; i < grid.length; i++) {
            for (int i1 = 0; i1 < grid[i].length; i1++) {
                if(laser[i][i1]){
                    grid[i][i1]=color;
                }
            }
        }

        // false代表查找中间点
        return grid;
    }

    private void dfs(int[][] grid,boolean[][] visit,boolean[][] laser,int x,int y,int oldColor){

        // 超出边界返回
        if (x<0||x> grid.length-1||y<0||y>grid[0].length-1){
            return;
        }

        //访问过的返回
        if(visit[x][y]){
            return;
        }

        // 到达其他连通分量返回
        if (grid[x][y]!=oldColor){
            return;
        }

        // 找到连通分量边界
        a:{
            for (int[] d : direction) {
                if (!(x + d[0] >= 0 && x + d[0] < grid.length && y + d[1] >= 0 && y + d[1] < grid[0].length&&grid[x + d[0]][y + d[1]] == oldColor)) {
                        laser[x][y] = true;
                        break a;
                }
            }
        }


        // 不重复访问节点
        visit[x][y]=true;

        for (int[] ints : direction) {
            dfs(grid,visit,laser,x+ints[0],y+ints[1],oldColor);
        }

    }

    public static void main(String[] args) {
        No1034 n=new No1034();
//        int[][] grid={{1,1,1},{1,1,1},{1,1,1}};
//        int[][] grid={{1,2,2},{2,3,2}};
        int[][] grid={{1,2,1,2,1,2},{2,2,2,2,1,2},{1,2,2,2,1,2}};

        int[][] res = n.colorBorder(grid, 1, 3, 1);

        for (int[] re : res) {
            for (int i : re) {
                System.out.print(i+",");
            }
            System.out.println();
        }

    }
}
