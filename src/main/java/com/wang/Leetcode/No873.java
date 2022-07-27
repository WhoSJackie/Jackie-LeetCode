package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No873 {

    public int lenLongestFibSubseq(int[] arr) {
        if (arr.length<3){
            return 0;
        }
        // map存储arr数组，方便查找是否存在某个数
        Map<Integer,Integer> map = new HashMap<>();
        for (int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int[][] cache = new int[arr.length][arr.length];

        // 进行状态转移
        int max = 0;
        for (int i = 2; i < arr.length; i++) {
            for (int j=i-1;j>=0&&arr[j]*2>arr[i];j--){
                int temp = arr[i]-arr[j];
                if (map.containsKey(temp)&&map.get(temp)<j){
                    cache[j][i] = Math.max(cache[map.get(temp)][j]+1,3);
                }
                max = Math.max(cache[j][i],max);
            }
        }

        return max;

    }


    public static void main(String[] args) {
        System.out.println(new No873().lenLongestFibSubseq(new int[]{2,4,7,8,9,10,14,15,18,23,32,50}));
    }
}
