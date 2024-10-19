package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No051 {


        int n;
        List<List<String>> res;
        public List<List<String>> solveNQueens(int n) {
            this.n=n;
            res=new LinkedList<>();
            // 每行中列占用的位置
            int[] c = new int[n];
            // 行被占用情况
            boolean[] r = new boolean[n];
            // 左上角占用情况
            boolean[] tlc = new boolean[2*n-1];
            // 右上角占用情况
            boolean[] trc = new boolean[2*n-1];
            backTrace(0,c,r,tlc,trc);
            return res;
        }

        public void backTrace(int row,int[] c,boolean[] r,boolean[] tlc,boolean[] trc){
            if(row==n){
                List<String> tmp = new ArrayList<>();
               char[] chs = new char[n];
                for (int oc : c) {
                    Arrays.fill(chs,'.');
                    chs[oc] = 'Q';
                    tmp.add(new String(chs));
                }
                res.add(tmp);
            }

            for (int i = 0; i < n; i++) {
                int rc = row-i+n-1;
                if (!r[i] && !tlc[rc] && !trc[row+i]){
                    r[i] = tlc[rc] = trc[row+i] = true;
                    c[row] = i;
                    backTrace(row+1,c,r,tlc,trc);
                    r[i] = tlc[rc] = trc[row+i] = false;
                }
            }
        }


    public static void main(String[] args) {
        for (int i = 1; i <= 9; i++) {
            System.out.println(new No051().solveNQueens(i).size());
        }

    }

}
