package com.wang.Leetcode.HUAWEI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchPrimeNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int n = 2;
        List<Integer> list = new ArrayList();
        while (num>0&&num/n!=0){
            while (num>0&&num%n==0){
                list.add(n);
                num = num/n;
            }
            n++;
        }
        for (int a:list){
            System.out.println(a);
        }
    }

}
