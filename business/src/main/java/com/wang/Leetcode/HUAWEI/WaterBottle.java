package com.wang.Leetcode.HUAWEI;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WaterBottle {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<Integer> res = new ArrayList<>();
        int i = in.nextInt();
        while (i!=0){
            res.add(i);
            i = in.nextInt();
        }

        for (Integer re : res) {
            if (re==0){
                break;
            }
            System.out.println(getGlass(re));
        }

    }

    private static int getGlass(int num){
        int res = num;
        while (num>=3){
           int remainder = num%3;
           num = num/3;
           res+=num;
           num = num+remainder;
        }
        if (num==2) res++;
        return res;
    }

}
