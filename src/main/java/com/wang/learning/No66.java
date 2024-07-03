package com.wang.learning;

import java.sql.Array;
import java.util.*;

public class No66 {

    public int[] plusOne(int[] digits) {
        int len=digits.length;
        int sum=0;
        boolean flag=false;
        if(len>0){
            if(digits[0]==0){
                return new int[]{1};
            }
        }

        LinkedList<Integer> res=new LinkedList<>();
        for (int i = len-1; i >=0; i--) {
            if(flag) {
                if (digits[i] + 1 >= 10) {
                    flag = true;
                    res.push(digits[i]%9);
                } else {
                    flag = false;
                    res.push(digits[i] + 1);
                }
            }
            else {
                if(i==len-1){
                    if (digits[i] + 1 >= 10) {
                        flag = true;
                        res.push(digits[i] % 9);
                    } else {
                        flag = false;
                        res.push(digits[i] + 1);
                    }
                }
             else{
                    res.push(digits[i]);
                }
            }
        }

        if(flag){
            res.push(1);
        }

        int[] s=new int[res.size()];
        int index=0;
        while(!res.isEmpty()){
            s[index++]=res.pop();
        }
        return s;

    }

    public static void main(String[] args) {
        int[] a={8,9,9,9};
        for (int i : new No66().plusOne(a)) {
            System.out.println(i);
        }
    }
}
