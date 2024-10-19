package com.wang.Leetcode;

public class No372 {

    public int superPow(int a, int[] b) {
        return dfs(0,a,b);
    }

    private int dfs(int layer,int a,int[] b){
        if (layer==b.length) return 1;
        return fastPow(dfs(layer+1,a,b),10)*fastPow(a,b[b.length-layer-1])%1337;
    }

    private int fastPow(int a,int b){
        if (a==1 || b==0) return 1;
        long res = 1;
        long x = a%1337;
        long temp = b;
        while (temp>0){
            if ((temp&1)==1){
                res=res*x%1337;
            }
            x=x*x%1337;
            temp= temp>>1;
        }
        return (int) (res%Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        System.out.println(new No372().superPow(2147483647, new int[]{2,0,0}));
    }

}
