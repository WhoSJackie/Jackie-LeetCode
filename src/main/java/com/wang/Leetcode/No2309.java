package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class No2309 {

    // 法1 传统遍历
    public String greatestLetter(String s) {
        int len = s.length();
        char[] temp = s.toUpperCase().toCharArray();
        char ts = ' ';
        for (int i = 0; i < len; i++) {
            for (int j=i+1;j<len;j++){
                if (Math.abs(s.charAt(i)-s.charAt(j))==32){
                    if (ts-temp[i]<=0){
                        ts = temp[i];
                    }
                }
            }
        }
        return ts==' '?"":String.valueOf(ts);
    }

    // 法二 哈希表
    // 法三 string.indexOf()方法

}
