package com.wang.Leetcode;

public class No2432 {

    public int hardestWorker(int n, int[][] logs) {
        int max = logs[0][1];
        int maxId = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int temp = logs[i][1]-logs[i-1][1];
            if (temp>max){
                max = temp;
                maxId = logs[i][0];
            }
            if (temp==max){
                maxId = Math.min(logs[i][0],maxId);
            }
        }
        return maxId;
    }

}
