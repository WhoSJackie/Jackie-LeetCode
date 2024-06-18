package com.wang.Leetcode;

public class No1491 {

    public double average(int[] salary) {
        double res = 0.0;
        int max=-2147483648;
        int min = 2147483647;
        int len = salary.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max,salary[i]);
            min = Math.min(min,salary[i]);
        }
        for (int i = 0; i < len; i++) {
            if (salary[i]!=max&&salary[i]!=min) res+=salary[i];
        }
        return res/(len-2);
    }


}
