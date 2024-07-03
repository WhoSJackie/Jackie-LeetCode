package com.wang.learning;

import java.util.Arrays;
import java.util.Comparator;

public class No1710 {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        // 倒序对数组排序，存储值大的放前面
        Arrays.sort(boxTypes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1]-o1[1];
            }
        });
        int remain = truckSize;
        int count=0;
        for (int[] boxType : boxTypes) {
            if (remain>=boxType[0]){
                count+=boxType[0]*boxType[1];
                remain=remain-boxType[0];
            } else{
                count+=remain*boxType[1];
                remain=0;
            }
            if (remain==0){
                break;
            }
        }
        return count;
    }

}
