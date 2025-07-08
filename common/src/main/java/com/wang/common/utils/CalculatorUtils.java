package com.wang.common.utils;

public class CalculatorUtils {

    public static long getKb2Mb(long kb){
        return kb/1024;
    }

    public static boolean addEquals(long total,long... params){
        long sum=0;
        for (long param : params) {
            sum+=param;
        }
        return sum==total;
    }

    public static void main(String[] args) {
        System.out.println(CalculatorUtils.getKb2Mb(3289648));
        System.out.println(addEquals(3289648,14896,7168,3267584));
    }

}
