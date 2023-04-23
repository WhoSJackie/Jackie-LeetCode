package com.wang.Leetcode.get_offer;

public class Offer58 {

    public String reverseLeftWords(String s, int n) {
        if (s.length()<=1||n>=s.length()) return s;
        StringBuilder sb = new StringBuilder(s);
        String end = sb.substring(0,n);
        String fore = sb.substring(n);
        return fore+end;
    }

}
