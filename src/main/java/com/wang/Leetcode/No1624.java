package com.wang.Leetcode;

import java.util.HashMap;

public class No1624 {

    public int maxLengthBetweenEqualCharacters(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),i);
        }
        int max = -1;
        for (int i = 0; i<s.length(); i++) {
            if (map.containsKey(s.charAt(i))){
                max = Math.max((map.get(s.charAt(i))-i-1),max);
            }
        }

        return max;

    }

}
