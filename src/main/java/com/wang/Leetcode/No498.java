package com.wang.Leetcode;

public class No498 {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] res = new int[m*n];
        int x=0,y=0,cnt=0,ix=0;
        while (cnt<=m+n-2){
            if ((cnt&1)==0){
               if (cnt<m){
                   x = cnt;
               }else{
                   x = m-1;
               }
            }else{
                if (cnt<n){
                    x = 0;
                }else{
                    x = cnt-(n-1);
                }
            }
            while (x<m && x>=0 && cnt-x>=0 && cnt-x<n){
                if ((cnt&1)==0){
                    res[ix++] = mat[x][cnt-x];
                    x--;
                } else{
                    res[ix++] = mat[x][cnt-x];
                    x++;
                }
            }
            cnt++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] res = new No498().findDiagonalOrder(new int[][]{{2},{3}});
    }
}
