package com.wang.Leetcode.weekContest.week323;

import java.util.Arrays;

public class Allocator002 {
    int[] arr;

    public Allocator002(int n) {
        arr = new int[n];
    }

    public int allocate(int size, int mID) {
        int i = 0, cnt = 0;
        while (i < arr.length && cnt < size)
            if (arr[i++] == 0)
                cnt++;
            else
                cnt = 0;

        if (cnt < size)
            return -1;
        Arrays.fill(arr, i - cnt, i, mID);
        return i - cnt;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == mID) {
                cnt++;
                arr[i] = 0;
            }
        return cnt;
    }
}
