package com.wang.Leetcode.weekContest.week321;

public class No2486 {

    public int appendCharacters(String s, String t) {
        int index=0;
        int i=0;
        int j=0;
        while (i<s.length()&&j<t.length()){
            if (s.charAt(i)==t.charAt(j)){
                index=j;
                i++;
                j++;
            } else{
                i++;
            }
        }
        return index==t.length()?0:t.length()-index-1;
    }

}
