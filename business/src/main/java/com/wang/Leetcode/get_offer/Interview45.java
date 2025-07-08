package com.wang.Leetcode.get_offer;

import java.util.Arrays;
import java.util.Comparator;

public class Interview45 {

    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }

        // 快排，两个字符串拼接
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });

        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            sb.append(str);
        }
        return sb.toString();
    }

    public void quickSort(String[] strs,int l,int r){
        if (l>=r) return;
        int i = l;
        int j = r;
        String tmp = strs[l];
        while (l<r){
            while (l<r&&(strs[j]+strs[l]).compareTo(strs[l]+strs[j])>=0) j--;
            while (l<r&&(strs[i]+strs[l]).compareTo(strs[l]+strs[i])<0) i++;
            String temp = strs[i];
            strs[i] = strs[j];
            strs[j] = temp;
        }
        strs[l] = strs[i];
        strs[i] = tmp;
        quickSort(strs,l,i-1);
        quickSort(strs,i+1,j);
    }



}
