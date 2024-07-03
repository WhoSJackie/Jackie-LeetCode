package com.wang.learning;

import java.util.HashSet;
import java.util.Set;

public class No672 {
    int[] arr;
    int presses;
    Set<String> res ;
    public int flipLights(int n, int presses) {
        // 初始化模拟数组
        arr = new int[n];
        this.presses = presses;
        res = new HashSet<>();

        dfs(arr,0);
        return res.size();
    }

    public void dfs(int[] ar,int deep){
        //按压次数到达presses
        if (deep==presses){
            String tempStr = turnArrToString(arr);
            if (!res.contains(tempStr)){
                res.add(tempStr);
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            switch (i){
                case 0:
                    pressOne(arr);
                    dfs(arr,deep+1);
                    pressOne(arr);
                    break;
                case 1:
                    pressTwo(arr);
                    dfs(arr,deep+1);
                    pressTwo(arr);
                    break;
                case 2:
                    pressThree(arr);
                    dfs(arr,deep+1);
                    pressThree(arr);
                    break;
                case 3:
                    pressFour(arr);
                    dfs(arr,deep+1);
                    pressFour(arr);
                    break;
            }
        }


    }

    public String turnArrToString(int[] ar){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ar.length; i++) {
            sb.append(ar[i]);
        }
        return sb.toString();
    }

    public void pressOne(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == 0) {
                ar[i] = 1;
            } else {
                ar[i] = 0;
            }
        }
    }

    public void pressTwo(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            if (i%2==0){
                if (ar[i] == 0) {
                    ar[i] = 1;
                } else {
                    ar[i] = 0;
                }
            }
        }
    }

    public void pressThree(int[] ar){
        for (int i = 0; i < ar.length; i++) {
            if (i%2!=0){
                if (ar[i] == 0) {
                    ar[i] = 1;
                } else {
                    ar[i] = 0;
                }
            }
        }
    }

    public void pressFour(int[] ar){
        int index;
        for (int i = 0; i < ar.length; i++) {
            index = 3*i+1;
            if (index<ar.length){
                if (ar[index] == 0) {
                    ar[index] = 1;
                } else {
                    ar[index] = 0;
                }
            } else{
                return;
            }
        }
    }

    public static void main(String[] args) {
        new No672().flipLights(3,1);
    }

}
