package com.wang.Leetcode;

public class No1812 {

    public boolean squareIsWhite(String coordinates) {
        int first = coordinates.charAt(0)-'a';
        int second = coordinates.charAt(1)-'1';
        if ((first+second)%2!=0){
            return true;
        }
        return false;
    }

}
