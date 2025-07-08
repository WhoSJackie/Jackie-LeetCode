package com.wang.Leetcode.weekContest.week324;

import java.util.Arrays;

public class No2506 {

    public int similarPairs(String[] words) {
        if (words.length<=1){
            return 0;
        }
        int[] ch = new int[26];
        int len = words.length;
        // 统计每个word所包含的字母
        for (int i = 0; i < len; i++) {
            String str = words[i];
            Arrays.fill(ch,0);
            for (int j = 0; j < str.length(); j++) {
                ch[str.charAt(j)-'a']++;
            }
            // 将存在的字符连接成字符串
            StringBuilder temp = new StringBuilder();
            for (int k = 0; k < ch.length; k++) {
                if (ch[k]>0){
                    temp.append(k+'a');
                }
            }
            words[i] = temp.toString();
        }

        int cnt=0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i+1; j < words.length; j++) {
                if (words[i].equals(words[j])){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int cnt = new No2506().similarPairs(new String[]{"aba","aabb","abcd","bac","aabc"});
        System.out.println(cnt);
    }
}
