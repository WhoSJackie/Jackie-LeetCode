package com.wang.Leetcode.weekContest.week362;

import java.util.ArrayList;
import java.util.List;

public class No2850 {
    int res=Integer.MAX_VALUE;
    boolean[] vis;
    public int minimumMoves(int[][] grid) {
        // 创建fromList和ToList 两个数组尺寸一致
        List<int[]> fromList = new ArrayList<>(),toList = new ArrayList<>();
        // 收集移动的起始地和目的地数据
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j]==0){
                    toList.add(new int[]{i,j});
                } else if (grid[i][j]>1){
                    for (int k=0;k<grid[i][j]-1;k++){
                        fromList.add(new int[]{i,j});
                    }
                }
            }
        }
        // 进行回溯计算最佳结果
        vis = new boolean[fromList.size()];
        backTrace(fromList,0,toList,0);
        return res;
    }

    public void backTrace(List<int[]> fromList,int fromIndex,List<int[]> toList,int sum){
        if (fromIndex>=fromList.size()){
            res = Math.min(res,sum);
        }
        for (int i = 0; i < toList.size(); i++) {
            if (!vis[i]){
                vis[i] = true;
                backTrace(fromList,fromIndex+1,toList,sum+Math.abs(fromList.get(fromIndex)[0]-toList.get(i)[0])+Math.abs(fromList.get(fromIndex)[1]-toList.get(i)[1]));
                vis[i] = false;
            }
        }
    }
}
