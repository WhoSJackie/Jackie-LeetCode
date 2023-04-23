package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1042 {

    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] res = new ArrayList[n];
        int[] ans = new int[n];
        // 初始化
        for (int i = 0; i < n; i++) {
            res[i] = new ArrayList<>();
        }
        for (int i=0;i<paths.length;i++){
            res[paths[i][0]-1].add(paths[i][1]-1);
            res[paths[i][1]-1].add(paths[i][0]-1);
        }

        for (int i = 0; i < n; i++) {
            boolean[] color = new boolean[5];
            for (int num : res[i]) {
                color[ans[num]] = true;
            }

            for (int j = 1; j <= 4; j++) {
                if (!color[j]) ans[i] = j;
            }
        }
        return ans;
    }


}

