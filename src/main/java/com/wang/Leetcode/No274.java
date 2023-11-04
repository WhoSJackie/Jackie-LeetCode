package com.wang.Leetcode;

import java.util.Arrays;

public class No274 {

    public int hIndex(int[] citations) {
        int size = citations.length;
        int h=0;
        Arrays.sort(citations);
        int temp = citations[0];
        for (int i = size-1; i >0; i--) {
             temp = citations[i];
            for (int j=temp;j>=citations[i-1];j--){
               if ((size-i)>=j){
                   h = j;
                   break;
               }
            }
            if (h!=0) break;
        }
        // 下标为0时
        if (h==0){
            for (int j=temp;j>=0;j--){
                if (size>=j){
                    h = j;
                    break;
                }
            }
        }
        return h;
    }

    public static void main(String[] args) {
        System.out.println(new No274().hIndex(new int[]{3, 0, 6, 1, 5}));
    }

}
