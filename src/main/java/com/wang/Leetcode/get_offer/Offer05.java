package com.wang.Leetcode.get_offer;

public class Offer05 {

    public String replaceSpace(String s) {
        if (s.length()<=0) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == ' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            } else{
                sb.append(temp);
            }
        }
        return sb.toString();
    }

}
