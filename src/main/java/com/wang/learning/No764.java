package com.wang.learning;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class No764 {

    public int orderOfLargestPlusSign(int n, int[][] mines) {
        if (n<=1){
            return 0;
        }
        int max=0;
        int[][] arr = new int[n][n];
        for (int[] ints : arr) {
            Arrays.fill(ints,Integer.MAX_VALUE);
        }

        Set<Integer> set = new HashSet<>();
        for (int[] mine : mines) {
            set.add(n*mine[0]+mine[1]);
        }
        return handleMaxClass(arr,n,set);
    }

    private int handleMaxClass(int[][] arr,int n,Set<Integer> set){
        int count=0;
        int res=0;
        // 往四个方向延伸

        for (int i = 0; i < n; i++) {
            count=0;
            // left
            for (int j = 0; j < n; j++) {
                if (set.contains(i*n+j)){
                    count=0;
                } else{
                    count++;
                }
                arr[i][j] = Math.min(arr[i][j],count);
            }
            // right
            for (int j = n-1; j >= 0; j--) {
                if (set.contains(i*n+j)){
                    count=0;
                } else{
                    count++;
                }
                arr[i][j] = Math.min(arr[i][j],count);
            }
        }

        for (int j=0;j<n;j++){
            // up
            count=0;
            for (int i = 0; i < n; i++) {
                if (set.contains(i*n+j)){
                    count=0;
                } else{
                    count++;
                }
                arr[i][j] = Math.min(arr[i][j],count);
            }
            // down
            count=0;
            for (int i = n-1; i >=0 ; i--) {
                if (set.contains(i*n+j)){
                    count=0;
                } else{
                    count++;
                }
                arr[i][j] = Math.min(arr[i][j],count);
                res = Math.max(arr[i][j],res);
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }

}
