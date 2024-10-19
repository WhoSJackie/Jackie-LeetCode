package com.wang.Leetcode;

public class No058 {

    public int lengthOfLastWord(String s) {
        char[] chs = s.toCharArray();
        int len  = chs.length;
        int res=0;
        int ix = len-1;
        // 跳过空格
        while (ix>=0 && chs[ix]==' '){
            ix--;
        }
        while (ix>=0 && chs[ix]!=' ') {
            res++;
            ix--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No058().lengthOfLastWord("   fly me   to   the moon  "));
    }

}
