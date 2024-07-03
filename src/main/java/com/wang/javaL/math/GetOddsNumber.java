package com.wang.javaL.math;

public class GetOddsNumber {

    public String  getOddsCount(int n){
        if (n==0){
            return "";
        }
        if (n==1){
            return "a";
        }
        StringBuilder sb = new StringBuilder();
        if (n%2!=0){
            for (int i = 0; i < n; i++) {
                sb.append('a');
            }
            return sb.toString();
        }
        // 为偶数
        for (int i = 0; i < n-1; i++) {
            sb.append('a');
        }
        sb.append('b');
        return sb.toString();
    }

}