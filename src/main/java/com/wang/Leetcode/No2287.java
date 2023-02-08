package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No2287 {

    public int rearrangeCharacters(String s, String target) {
        int[] map = new int[26];
        int[] tarCnt = new int[26];
        int lens = s.length();
        int lent = target.length();
        // 将target的每个字符数统计一下
        for (int i = 0; i < lent; i++) {
            char c = target.charAt(i);
            map[c-'a']++;
        }

        // 统计s中的字符数
        for (int i = 0; i < lens; i++) {
            char c = s.charAt(i);
            if (map[c-'a']!=0){
                tarCnt[c-'a']++;
            }
        }

        int count=Integer.MAX_VALUE;
        for (int i=0;i<26;i++) {
            if (map[i]!=0){
                count = Math.min(tarCnt[i]/map[i],count);
            }
        }
        return count;
    }

    public static void main(String[] args){
        System.out.println(new No2287().rearrangeCharacters("abcba", "abc"));
    }
}
