package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No2586 {

    public int vowelStrings(String[] words, int left, int right) {
        int cnt=0;
        List<Character> pos = new ArrayList<>();
        pos.add('a');
        pos.add('e');
        pos.add('i');
        pos.add('o');
        pos.add('u');
        for (int i = left; i <= right; i++) {
            char l = words[i].charAt(0);
            char r = words[i].charAt(words[i].length()-1);
            if (pos.contains(l)&&pos.contains(r)){
                cnt++;
            }
        }
        return cnt;
    }

}
