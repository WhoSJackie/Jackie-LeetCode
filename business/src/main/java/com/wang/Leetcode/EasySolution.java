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

    public static void main(String[] args) {
        System.out.println(new EasySolution().coinChange(new int[]{1,2,5},11));
    }


}
