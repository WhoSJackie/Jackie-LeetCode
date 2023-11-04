package com.wang.Leetcode;

import java.util.*;

public class No1090 {

    public int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int len = values.length;
        // 收集标签下标
        int maxLabel = -1;
        // 统计values中最大的数字
        for (int i=0;i<values.length;i++) {
            maxLabel = Math.max(maxLabel,labels[i]);
        }
        int[] limitLabel = new int[maxLabel+1];
        // 初始化
        for (int i=0;i<labels.length;i++){
            limitLabel[labels[i]] = useLimit;
        }

        // 以value值对下标倒序排序
        Integer[] indexMat = new Integer[len];
        for (int i=0;i<len;i++){
            indexMat[i] = i;
        }
        Arrays.sort(indexMat,(a,b)->values[b]-values[a]);

        int numW = numWanted;
        Set<Integer> set = new HashSet<>();
        int max = 0;
        // 进行计算
        for (int i = 0; i <len; i++) {
            int tlabel = labels[indexMat[i]];
            int tvalue = values[indexMat[i]];
            if (set.contains(tlabel)){
                if(limitLabel[tlabel]==0) continue;
            } else{
                set.add(tlabel);
            }
            max+=tvalue;
            limitLabel[tlabel]--;
            if (--numW==0) break;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new No1090().largestValsFromLabels(new int[]{3,2,3,2,1}, new int[]{1,0,2,2,1}, 2, 1));
    }

}
