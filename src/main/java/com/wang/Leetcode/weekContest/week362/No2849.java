package com.wang.Leetcode.weekContest.week362;

import java.util.LinkedList;
import java.util.Queue;

public class No2849 {
    int[][] direction = new int[][]{{1,0},{0,1},{1,1},{0,-1},{-1,0},{1,-1},{-1,1},{-1,-1}};
    public boolean isReachableAtTime(int sx, int sy, int fx, int fy, int t) {
        if (sx==fx&&sy==fy) return t!=1;
        int res = Math.max(Math.abs(sx-fx),Math.abs(sy-fy));
        return res<=t;
        // bfs
//        boolean[][] vis = new boolean[120][120];
//        // 新建一个队列
//        Queue<Integer[]> queue = new LinkedList<>();
//        queue.offer(new Integer[]{sx,sy});
//        int size=0;
//        int cnt=0;
//        while (queue.size()>0){
//            size = queue.size();
//            while (size>0){
//                Integer[] temp = queue.poll();
//                int x = temp[0];
//                int y = temp[1];
//                vis[temp[0]][temp[1]] = true;
//                if (temp[0]==fx&&temp[1]==fy){
//                    return cnt<=t;
//                }
//                for (int[] dic : direction) {
//                    if (x+dic[0]>=0&&y+dic[1]>=0&&x+dic[0]<=109&&y+dic[1]<=109&&!vis[x+dic[0]][y+dic[1]]){
//                        queue.offer(new Integer[]{x+dic[0],y+dic[1]});
//                    }
//                }
//                size--;
//            }
//            cnt++;
//        }
//        // dfs(sx,sy,0);
//        return false;
    }



    public static void main(String[] args) {
        System.out.println(new No2849().isReachableAtTime(1, 2, 1, 2, 1));
    }


}
