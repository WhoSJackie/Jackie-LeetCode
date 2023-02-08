package com.wang.Leetcode.weekContest.week323;

import java.util.*;

public class No2503 {

    // 法一 直接遍历queries+dfs 超时 17/21
//    int[] res;
//    public int[] maxPoints(int[][] grid, int[] queries) {
//        int len = queries.length;
//        res = new int[len];
//        boolean[][] visited = new boolean[grid.length][grid[0].length];
//        // 初始化visited数组
//        for (int i=0;i< visited.length;i++){
//            for (int j=0;j<visited[0].length;j++){
//                visited[i][j] = false;
//            }
//        }
//
//        for (int i=0;i<queries.length;i++) {
//            dfs(i,grid,queries[i],visited,0,0);
//            // vis还原
//            for (int x=0;x< visited.length;x++){
//                for (int y=0;y<visited[0].length;y++){
//                    visited[x][y] = false;
//                }
//            }
//        }
//
//        return res;
//    }
//
//    // 向下和右做dfs
//    public void dfs(int index,int[][] grid,int query,boolean[][] visited,int i,int j){
//        if (i>=grid.length||i<0||j>=grid[0].length||j<0||grid[i][j]>=query||visited[i][j]) return;
//
//        if (!visited[i][j]) {
//            res[index]++;
//            visited[i][j] = true;
//        }
//        dfs(index,grid,query,visited,i+1,j);
//        dfs(index,grid,query,visited,i,j+1);
//        dfs(index,grid,query,visited,i-1,j);
//        dfs(index,grid,query,visited,i,j-1);
//    }


    int[][] dic = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    // 法二 小根堆+bfs
    public int[] maxPoints(int[][] grid, int[] queries) {
        int row = grid.length;
        int col = grid[0].length;
        int n = queries.length;
        int[] res = new int[n];
        // 需要记录queries排序后的下标数组
        Integer[] index = new Integer[n];
        for (int i = 0; i < n; i++) {
            index[i] = i;
        }
        Arrays.sort(index,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return queries[o1]-queries[o2];
            }
        });

        Queue<int[]> queue1 = new ArrayDeque<>();
        boolean[][] vis = new boolean[row][col];
        PriorityQueue<int[]> queue2 = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        return grid[o1[0]][o1[1]]-grid[o2[0]][o2[1]];
                    }
                }
        );
        queue2.offer(new int[]{0,0});
        vis[0][0] = true;
        int count = 0;
        int num = 0;
        while (count<n){
            int limit = queries[index[count]];
            // 小根堆里取出符合条件的放入queue1，进行bfs
            while (!queue2.isEmpty()&&grid[queue2.peek()[0]][queue2.peek()[1]]<limit){
                queue1.offer(queue2.poll());
            }

            while (!queue1.isEmpty()){
                int[] re = queue1.poll();
                // queue1中的都是符合条件的
                num++;
                // 向四个方向走
                for (int i = 0; i < dic.length; i++) {
                    int x = re[0]+dic[i][0];
                    int y = re[1]+dic[i][1];
                    if (isValid(row,col,x,y)&&!vis[x][y]){
                        vis[x][y] = true;
                        if (grid[x][y]<limit){
                            queue1.offer(new int[]{x,y});
                        } else{
                            queue2.offer(new int[]{x,y});
                        }
                    }
                }
            }
            // 出队处理完毕，统计数量
            res[index[count]] = num;
            count++;
        }

        return res;
    }

    private boolean isValid(int limitx,int limity,int x,int y){
        if (x>=limitx||x<0||y>=limity||y<0) return false;
        return true;
    }


    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {249472,735471,144880,992181,760916,920551,898524,37043,422852,194509,714395,325171},
                {295872,922051,900801,634980,644237,912433,857189,98466,725226,984534,370121,399006},
                {618420,573065,587011,298153,694872,12760,880413,593508,474772,291113,852444,77998},
                {67650,426517,146447,190319,379151,184754,479219,106819,138473,865661,799297,228827},
                {390392,789371,772048,730506,7144,862164,650590,21524,879440,396198,408897,851020},
                {932044,662093,436861,246956,128943,167432,267483,148325,458128,418348,900594,831373},
                {742255,795191,598857,441846,243888,777685,313717,560586,257220,488025,846817,554722},
                {252507,621902,87704,599753,651175,305330,620166,631193,385405,183376,432598,706692},
                {984416,996917,586571,324595,784565,300514,101313,685863,703194,729430,732044,349877},
                {155629,290992,539879,173659,989930,373725,701670,992137,893024,455455,454886,559081},
                {252809,641084,632837,764260,68790,732601,349257,208701,613650,429049,983008,76324},
                {918085,126894,909148,194638,915416,225708,184408,462852,40392,964501,436864,785076},
                {875475,442333,111818,494972,486734,901577,46210,326422,603800,176902,315208,225178},
                {171174,458473,744971,872087,680060,95371,806370,322605,349331,736473,306720,556064},
                {207705,587869,129465,543368,840821,977451,399877,486877,327390,8865,605705,481076}};
        No2503 n = new No2503();
        int[] res = n.maxPoints(grid,new int[]{690474,796832,913701,939418,46696,266869,150594,948153,718874});
        for (int re : res) {
            System.out.println(re);
        }

    }

}
