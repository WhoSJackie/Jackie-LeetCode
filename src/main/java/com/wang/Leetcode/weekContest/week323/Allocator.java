package com.wang.Leetcode.weekContest.week323;

import java.util.Arrays;

public class Allocator {

    private int[] arr;

    public Allocator(int n) {
        arr = new int[n];
    }

    public int allocate(int size, int mID) {
        if (size>arr.length){
            return -1;
        }
        int cnt = 0;
        int i=0;
        while ((i<arr.length)&&(cnt<size)){
            if (arr[i++]==0){
                cnt++;
            } else{
                cnt=0;
            }
        }
        if (cnt<size) return -1;
        Arrays.fill(arr,i-size,i,mID);
        return i;
    }

    public int free(int mID) {
        int cnt = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]==mID) {
                arr[i] = 0;
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        Allocator loc = new Allocator(7);
        loc.allocate(7, 8);
        loc.allocate(8, 7);
        loc.allocate(6, 2);
        loc.free(9);
        loc.free(8);
        loc.allocate(7, 6);
        loc.free(9);
        loc.allocate(10, 9);
    }

}
