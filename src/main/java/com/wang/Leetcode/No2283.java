package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No2283 {

    public boolean digitCount(String num) {
        Map<Integer,Integer> map = new HashMap<>();
        int len = num.length();
        // 预处理
        for (int i = 0; i < len; i++) {
            if (map.containsKey(num.charAt(i)-'0')){
                map.put(num.charAt(i)-'0',map.get(num.charAt(i)-'0')+1);
            } else{
                map.put(num.charAt(i)-'0',1);
            }
        }

        for (int i = 0; i < len; i++) {
            // 针对Num中没出现的数字处理
            if (map.getOrDefault(i,0)!=num.charAt(i)-'0'){
                return false;
            }
        }
        return true;
    }

    public boolean digitCount1(String num){
        int len = num.length();
        int[] count = new int[10];
        for (int i = 0; i < len; i++) {
            char c = num.charAt(i);
            count[c-'0']++;
        }

        for (int i = 0; i < len; i++) {
            if (count[i]!=num.charAt(i)-'0'){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        System.out.println(new No2283().digitCount("1210"));
    }

}
