package com.wang.Leetcode;

public class No593 {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        return isRT(p1,p2,p3)&&isRT(p1,p3,p4)&&isRT(p1,p2,p4)&&isRT(p2,p3,p4);
    }

    private boolean isRT(int[] a,int[] b,int[] c){
        // 求出三点中任意两点距离的平方
        int len1 = (a[0]-b[0])*(a[0]-b[0])+(a[1]-b[1])*(a[1]-b[1]);
        int len2 = (a[0]-c[0])*(a[0]-c[0])+(a[1]-c[1])*(a[1]-c[1]);
        int len3 = (c[0]-b[0])*(c[0]-b[0])+(c[1]-b[1])*(c[1]-b[1]);

        boolean flag = (len1==len2&&(len1+len2==len3))||(len2==len3&&(len2+len3==len1))||(len1==len3&&(len1+len3==len2));
        if (!flag){
            return false;
        }
        if (len1==0||len2==0||len3==0) return false;
        return true;
    }
}
