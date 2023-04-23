package com.wang.Leetcode.get_offer;

public class Offer48 {

    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=0) return 0;
        int len = s.length();
        int i=0;
        int j=0;
        int max = 1;
        int num = 1;
        while (i<len&&j+1<len){
            num = j-i+1;
            // 不断移动右边界
            while (j+1<len&&!s.substring(i,j+1).contains(String.valueOf(s.charAt(++j)))){
                num++;
            }
            max = Math.max(max,num);
            // 不断移动左边界
            while ((i<len)&&(i<j)&&(s.substring(i,j).contains(String.valueOf(s.charAt(j))))){
                i++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Offer48().lengthOfLongestSubstring(s));
    }

}
