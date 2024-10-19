package com.wang.Leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class No1365 {
    // 法一 排序法
    public int[] smallerNumbersThanCurrent1(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        int[][] tmp = new int[len][2];
        for (int i = 0; i < len; i++) {
            tmp[i][0] = nums[i];
            tmp[i][1] = i;
        }
        Arrays.sort(tmp, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        for (int i = 0; i < len; i++) {
            if (i>=1 && tmp[i][0]==tmp[i-1][0]) {
                res[tmp[i][1]] = res[tmp[i-1][1]];
            } else{
                res[tmp[i][1]] = i;
            }
        }
        return res;

    }

    // 法二 计数法
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] tmp = new int[101];
        int[] res = new int[len];
        // 数组计数
        for (int i = 0; i < len; i++) {
            tmp[nums[i]]++;
        }
        int cnt=0;
        // 统计数组
        for (int i = 1; i <= 100; i++) {
            tmp[i]+=tmp[i-1];
        }
        // 计算结果数组
        for (int i = 0; i < len; i++) {
            res[i] = nums[i]==0?0:tmp[nums[i]-1];
        }
        return res;
    }


    public static void main(String[] args) {
        int[] res = new No1365().smallerNumbersThanCurrent(new int[]{5,0,10,0,10,6});
        for (int i : res) {
            System.out.println(i);
        }
    }

}
