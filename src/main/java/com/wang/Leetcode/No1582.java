package com.wang.Leetcode;

public class No1582 {
    boolean[] colvisitor = null;
    boolean[] linvisitor = null;
    public int numSpecial(int[][] mat) {
        linvisitor = new boolean[mat.length];
        colvisitor = new boolean[mat[0].length];
        int res=0;
        for (int i = 0; i < mat.length; i++) {
            for (int i1 = 0; i1 < mat[0].length; i1++) {
                if (mat[i][i1]==1&&!linvisitor[i]&&!colvisitor[i1]&&numSpecial(mat,i,i1)){
                    res++;
                }
            }
        }
        return res;
    }

    private boolean numSpecial(int[][] mat,int x,int y){
        // 判断行是否存在1
        for (int i = 0; i < mat[x].length; i++) {
            if (i!=y&&mat[x][i]==1){
                // 整行不需要再次访问
                linvisitor[x] = true;
                return false;
            }
        }

        // 判断列是否存在1
        for (int j = 0; j < mat.length; j++) {
            if (j!=x&&mat[j][y]==1){
                // 整列不需要再次访问
                colvisitor[y] = true;
                return false;
            }
        }
        return true;
    }
}
