package com.wang.Leetcode.HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

public class FindRepeatableNum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int len = str.length();
        String[] res = new String[len % 8 > 0 ? len / 8 + 1 : len / 8];
        int index = 0;
        int r = 0;
        StringBuilder sb = new StringBuilder();
        while (index < len) {
            sb.append(str.charAt(index++));
            if (index<len&&index%8==0){
                if (r<res.length){
                    res[r++] = sb.toString();
                }
                sb = new StringBuilder();
            }
        }
        while (index % 8 != 0){
            sb.append('0');
            index++;
        }
        if (r<res.length){
            res[r++] = sb.toString();
        }


        for (int i=0;i<res.length;i++){
            System.out.println(res[i]);
        }

    }


}
