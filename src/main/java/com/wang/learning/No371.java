package com.wang.learning;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class No371 {
    public static int getSum(int a, int b) {
        int s=0;
        int r=0;
        do{
            s=a^b;
            r=(a&b)<<1;
            a=s;
            b=r;
        }while(r!=0);
        int sum=a^b;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum(3, 5));
    }
}
