package com.wang.java_Learning;


import java.util.Arrays;
import java.util.stream.Collectors;

public class StringTest {

    public static String splitSoh(String str){
        String[] strs = str.split("");
        for (String s : strs) {
            System.out.print(s);
            System.out.print(" ");
        }
        return Arrays.stream(strs).collect(Collectors.joining());
    }


    public static void main(String[] args) {
        splitSoh("zxd022\u00011\u00012\u00012;3\u0001测试022\u0001tyxy022\u00011;0\u00010\u00010\n" +
                "zxd0221\u00011\u00012\u00012;3;1\u0001测试022\u0001tyxy022\u00011;0\u00010\u00010\n");

    }


}
