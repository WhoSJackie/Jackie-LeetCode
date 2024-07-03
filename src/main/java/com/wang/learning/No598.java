package com.wang.learning;

public class No598 {
    public int maxCount(int m, int n, int[][] ops) {
        if(ops.length==0||ops[0].length==0){
            return m*n;
        }
        int minx=Integer.MAX_VALUE;
        int miny=Integer.MAX_VALUE;
        for (int i = 0; i < ops.length; i++) {
            minx=Math.min(ops[i][0],minx);
            miny=Math.min(ops[i][1],miny);
        }

        return minx*miny;

    }

    public static void main(String[] args) {
        int[][] ops={{2,2},{3,3}};
        System.out.println(new No598().maxCount(3, 3, ops));
    }
}
