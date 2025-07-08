package com.wang.Leetcode.weekContest.week353;

import java.util.Arrays;

public class No2770 {
    // 从下至上的回溯+存储中间状态
//    private int tmpTarget;
//    private int[] tmp;
//    public int maximumJumps(int[] nums, int target) {
//        int len = nums.length;
//        tmp = new int[len];
//        Arrays.fill(tmp,-2); // -2代表状态没有改变 -1代表走不通 >-1代表走到终点最大步数
//        tmpTarget = target;
//        dfs(0,nums,len);
//        return tmp[0];
//    }
//
//    private int dfs(int layer,int[] nums,int len){
//        if (layer==len-1){
//            return 0;
//        }
//        if (tmp[layer]!=-2) return tmp[layer];
//        boolean hasNext = false;
//        for (int i=layer+1;i<len;i++){
//            if ((Math.abs(nums[layer]-nums[i])<=tmpTarget)){
//                int temp = dfs(i,nums,len);
//                if (temp!=-1){
//                    tmp[i]=Math.max(tmp[layer],temp+1);
//                    hasNext=true;
//                }
//            }
//        }
//        tmp[layer] = hasNext?tmp[layer]:-1;
//        return tmp[layer];
//    }

    // 从下至上的dp解法
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] S = new int[n];
        Arrays.fill(S,-1);
        S[n-1] = 0;
        for (int i = n-2; i >= 0; i--) {
            for (int j = i+1; j < n; j++) {
                if (isValid(nums[i],nums[j],target) && S[j] != -1) S[i] = Math.max(S[i],S[j]+1);
            }
        }
        return S[0];
    }

    public boolean isValid(int ni, int nj, int target) {
        return Math.abs(ni-nj) <= target;
    }





    public static void main(String[] args) {
        System.out.println(new No2770().maximumJumps(new int[]{-533985778,-424626669,794071124,694501105,-651162637,-789411200,773124493,-655591953,205086705,-421668572},1194793065));
        // System.out.println(new No2770().new Solution().maximumJumps(new int[]{1,2,1},0));

    }



}
