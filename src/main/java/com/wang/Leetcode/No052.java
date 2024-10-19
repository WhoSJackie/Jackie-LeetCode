package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No052 {

    int n;
    int res=0;
    public int totalNQueens(int n) {
        this.n=n;
        // 行被占用情况
        boolean[] r = new boolean[n];
        // 左上角占用情况
        boolean[] tlc = new boolean[2*n-1];
        // 右上角占用情况
        boolean[] trc = new boolean[2*n-1];
        backTrace(0,r,tlc,trc);
        return res;
    }

    public void backTrace(int row,boolean[] r,boolean[] tlc,boolean[] trc){
        if(row==n){
            res++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int rc = row-i+n-1;
            if (!r[i] && !tlc[rc] && !trc[row+i]){
                r[i] = tlc[rc] = trc[row+i] = true;
                backTrace(row+1,r,tlc,trc);
                r[i] = tlc[rc] = trc[row+i] = false;
            }
        }
    }


}
