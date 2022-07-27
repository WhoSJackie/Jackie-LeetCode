package com.wang.Leetcode;

import java.util.*;

public class No556 {
    List<Long> res;
    public int nextGreaterElement(int n) {
        res = new ArrayList<>();
        if (n>0&&n<10){
            return -1;
        }

        // 解开n
        List<Integer> rem = new ArrayList<>();
        int s = n;
        while(s>0){
            rem.add(s%10);
            s=s/10;
        }
        boolean[] vec = new boolean[rem.size()];

        for (int i = 0; i < rem.size(); i++){
            vec[i] = true;
            dfs(rem,0L,i,vec,0);
            vec[i] = false;
        }

        Collections.sort(res);
        for (int i = 0; i < res.size(); i++) {
            if (res.get(i)>n){
                return res.get(i).intValue();
            }
        }
        return -1;

    }

    private void dfs(List<Integer> list, Long num,int index, boolean[] vec, int deep){
        if (deep==list.size()-1){
            Long temp = num*10+list.get(index);
            if (temp<=Integer.MAX_VALUE){
                res.add(temp);
            }
        }
        vec[index] = true;
        for (int i = 0; i < list.size(); i++) {
            if (!vec[i]){
                dfs(list,num*10+list.get(index),i,vec,deep+1);
                vec[i]=false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new No556().nextGreaterElement(21));
    }

}
