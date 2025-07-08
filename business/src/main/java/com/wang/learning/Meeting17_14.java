package com.wang.learning;

import java.util.Arrays;

public class Meeting17_14 {
    public int[] smallestK(int[] arr, int k) {
        Arrays.sort(arr);
        int[] res=new int[k];
        for (int i = 0; i < k; i++) {
            res[i]=arr[i];
        }

        return res;
    }
}
