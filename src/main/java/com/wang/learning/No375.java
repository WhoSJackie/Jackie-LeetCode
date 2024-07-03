package com.wang.learning;

public class No375 {
    int[][] flag;
    public int getMoneyAmount(int n) {
        if(n<2){
            return 0;
        }
        flag=new int[n+1][n+1];
        return dfs(1,n);
    }

    public int dfs(int l,int r){
        if(l>=r) return 0;
        if(flag[l][r]!=0) return flag[l][r];
        int min=Integer.MAX_VALUE;
        for(int i=l;i<=r;i++){
            int res=Math.max(dfs(l,i-1),dfs(i+1,r))+i;
            min=Math.min(res,min);
        }
        flag[l][r]=min;
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new No375().getMoneyAmount(10));
    }
}
