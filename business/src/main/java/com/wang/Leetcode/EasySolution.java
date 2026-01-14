package com.wang.Leetcode;


import com.wang.common.ListNode;
import com.wang.common.Node;
import com.wang.common.RandomNode;
import com.wang.common.TreeNode;
import com.wang.common.utils.ListNodeUtil;
import com.wang.common.utils.TreeNodeUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class EasySolution {

    public boolean canJump(int[] nums) {
        int max = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= len) return true;
            } else {
                if (max < len) return false;
            }
        }
        return true;
    }

    public int jump(int[] nums) {
        int len = nums.length;
        int curDest = 0, cnt = 0, max = nums[0];
        for (int i = 0; i < len; i++) {
            if (curDest >= len-1) return cnt;
            while (i < len && i <= curDest) {
                max = Math.max(max, i + nums[i]);
                i++;
            }
            i--;
            curDest = max;
            cnt++;
        }
        return cnt;
    }

    public int coinChange(int[] coins, int amount) {
        int size = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;
        for (int j = 0; j < size; j++) {
            for (int i = coins[j]; i <= amount; i++) {
                if (dp[i-coins[j]]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[i-coins[j]]+1);
                }
            }
        }
        return dp[amount]==Integer.MAX_VALUE?-1:dp[amount];
    }

    public int countCollisions(String directions) {
        int cnt = 0,flag = -1;
        char[] dir = directions.toCharArray();
        int len = directions.length();
        for (int i = 0; i < len; i++) {
            if (dir[i]=='L'){
                // L
                if (flag>=0) {
                    cnt+=flag+1;
                    flag = 0;
                } else flag = -1;
            } else if (dir[i] == 'R'){
                // R
                if (flag>=0) flag++;
                else flag = 1;
            } else{
                if (flag>0) cnt+=flag;
                flag = 0;
            }
        }
        return cnt;
    }

    public long maxRunTime(int n, int[] batteries) {
        int len = batteries.length;
        long sum=0;
        // 求sum
        for (int i = 0; i < len; i++) {
            sum+=batteries[i];
        }
        long l = 0,r = sum/n;
        while (l<=r){
            long mid = l+(r-l)/2;
            // 求当前可用电池额度
            long supply=0;
            for (int i = 0; i < len; i++) {
                supply+=Math.min(mid,batteries[i]);
            }
            if (supply>=mid*n) l = mid+1;
            else if (supply<mid*n) r = mid-1;
        }
        return r;
    }

    public int countTriples(int n) {
        int cnt = 0;
        Set<Integer> hash = new HashSet<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j<=i-1; j++) {
                int a = i*i-j*j;
                if (hash.contains(a)){
                    cnt++;
                }
            }
            hash.add(i*i);
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new EasySolution().countTriples(5));
    }


}
