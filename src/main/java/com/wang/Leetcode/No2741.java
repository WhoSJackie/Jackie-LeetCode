package com.wang.Leetcode;

import java.util.*;

public class No2741 {
    int res;
    boolean[] vis;
    public int specialPerm1(int[] nums) {
        System.out.println("开始时间:"+System.currentTimeMillis());
        long cur = System.currentTimeMillis();
        res=0;
        vis = new boolean[nums.length];
        for (int i=0;i<nums.length;i++){
            vis[i] = true;
            dfs(0,nums,i);
            vis[i] = false;
        }
        System.out.println("共耗时:"+(System.currentTimeMillis()-cur)/1000);
        return res;
    }

    // dfs 超时
    private void dfs(int depth,int[] nums,int curIndex){
        if (depth==nums.length-1){
            // 到达最后一层，计数
            res = (res+1)%Integer.MAX_VALUE;
            return;
        }

        for (int i=0;i<nums.length;i++){
            if (vis[i]||(nums[i]%nums[curIndex]!=0 && nums[curIndex]%nums[i]!=0)) continue;
            vis[i] = true;
            dfs(depth+1,nums,i);
            vis[i] = false;
        }
    }

    public int specialPerm(int[] nums) {
        int len = nums.length;
        long[][] mat = new long[1<<len][len];
        for (int i = 0; i < mat.length; i++) {
            Arrays.fill(mat[i],-1);
        }
        long res=0;
        res = dfs(0,len,-1,mat,nums);
        return (int)(res%1000000007);
    }

    private long dfs(int depth,int n,int pre,long[][] mat,int[] nums){
        if (depth==(1<<n)-1){
            return 1;
        }
        if (pre!=-1&&mat[depth][pre]!=-1){
            return mat[depth][pre];
        }
        long res=0;
        for (int i = 0; i < n; i++) {
            if (((depth>>i)&1)==0 && (pre==-1 || nums[i]%nums[pre]==0 || nums[pre]%nums[i]==0)){
                res+=dfs((depth | (1<<i)),n,i,mat,nums);
            }
        }
        if (pre!=-1) mat[depth][pre] = res;
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new No2741().specialPerm(new int[]{1,2,4,8,16,32,64,128,256,512,1024,2048,4096,8192}));
    }

}
