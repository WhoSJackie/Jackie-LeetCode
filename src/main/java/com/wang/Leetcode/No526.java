package com.wang.Leetcode;

import java.util.*;

public class No526 {
    // dfs 法一:普通回溯
    public int countArrangement1(int n) {
        int res=0;
        boolean[] vis = new boolean[n+1];
        res=dfs(0,n,vis);
        return res;
    }

    private int dfs(int depth,int n,boolean[] vis){
        if (depth==n){
            // 到达最后一层，计数
            return 1;
        }
        int tmp=0;

        for (int i=1;i<n+1;i++){
            if (vis[i]||(i%(depth+1)!=0&&(depth+1)%i!=0)) continue;
            vis[i] = true;
            tmp+=dfs(depth+1,n,vis);
            vis[i] = false;
        }
        return tmp;
    }

    // 法二:回溯+记忆化（数组）超时
    Map<Set<Integer>,Integer> memo;
    public int countArrangement2(int n) {
        memo = new HashMap<>();
        int res=0;
        Set<Integer> set = new HashSet<>();
        boolean[] vis = new boolean[n+1];
        res=memoDfs(set,n,vis);
        return res;
    }

    private int memoDfs(Set<Integer> set,int n,boolean[] vis){
        int depth = set.size();
        if (depth==n){
            // 到达最后一层，计数
            return 1;
        }
        // 如果结果已经存在，则直接返回
        for (Map.Entry<Set<Integer>, Integer> entry : memo.entrySet()) {
            if ((entry.getKey().containsAll(set))&&(set.containsAll(entry.getKey()))){
                return entry.getValue();
            }
        }
        int tmp=0;
        for (int i=1;i<n+1;i++){
            if (vis[i]||(i%(depth+1)!=0&&(depth+1)%i!=0)) continue;
            vis[i] = true;
            set.add(i);
            tmp+=memoDfs(set,n,vis);
            set.remove(i);
            // 回溯
            vis[i] = false;
        }
        // 计算完毕，进行记忆化存储
        memo.put(new HashSet<>(set),tmp);
        return tmp;
    }

    // 法三:位运算+记忆dfs
    public int countArrangement(int n) {
        int[] memo = new int[1 << n];
        Arrays.fill(memo, -1); // -1 表示没有计算过
        return dfs(0, n, memo);
    }

    private int dfs(int s, int n, int[] memo) {
        if (s == (1 << n) - 1) {
            return 1;
        }
        if (memo[s] != -1) { // 之前计算过
            return memo[s];
        }
        int res = 0;
        int i = Integer.bitCount(s) + 1;
        for (int j = 1; j <= n; j++) {
            if ((s >> (j - 1) & 1) == 0 && (i % j == 0 || j % i == 0)) {
                res += dfs(s | (1 << (j - 1)), n, memo);
            }
        }
        memo[s] = res; // 记忆化
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new No526().countArrangement(10));
    }

}
