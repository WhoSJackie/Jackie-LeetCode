package com.wang.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1331 {
    public int[] arrayRankTransform(int[] arr) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = arr.length;
        int[] tempArr = arr.clone();
        sort(0,len-1,tempArr);
        int in = -1;
        for (int i = 0; i < len; i++) {
            if (map.get(tempArr[i])==null){
                in++;
            }
            map.putIfAbsent(tempArr[i],in+1);
        }
        int index = 0;
        for (int i = 0; i < len; i++) {
             index = map.get(arr[i]);
             arr[i] = index;
        }

        return arr;

    }

    private void sort(int i,int j,int[] arr){
        if (i>=j){
            return;
        }
        int temp = arr[i];
        int l = i;
        int r = j;

        while(i<j){
            while(i<j && arr[j]>=temp) j--;
            while(i<j && arr[i]<=temp) i++;
            int t = arr[i];
            arr[i] = arr[j];
            arr[j] = t;
        }
        arr[l] = arr[i];
        arr[i] = temp;
        sort(l,i-1,arr);
        sort(i+1,r,arr);
    }

    public static void main(String[] args) {
        int[] arr = {40,40,10,10};
        int[] ints = new No1331().arrayRankTransform(arr);
        for (int i : ints) {
            System.out.println(i);
        }
    }
}
