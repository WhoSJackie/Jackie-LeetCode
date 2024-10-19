package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class No670 {

    public int maximumSwap(int num) {
        if (num>=0&&num<=9) return num;
        List<Integer> list = new ArrayList<>();
        int a = num;
        int b = 0;
        while (a!=0){
            b = a%10;
            a = a/10;
            list.add(b);
        }
        // 收集最大前缀和
        int n = list.size();
        int[] idx = new int[n];
        for (int j = 0,i = 0; i < n; i++) {
            if (list.get(i)>list.get(j)) j = i;
            idx[i] = j;
        }
        int t = 0;
        for (int i=n-1;i>=0;i--){
            if (list.get(i) != list.get(idx[i])){
                t = list.get(i);
                list.set(i,list.get(idx[i]));
                list.set(idx[i],t);
                break;
            }
        }
        // 拼接回去
        int res = 0;
        for (int i=n-1;i>=0;i--) res = res*10+list.get(i);
        return res;
    }

    public static void main(String[] args) {
    }

}
