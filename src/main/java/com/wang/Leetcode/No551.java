package com.wang.Leetcode;

public class No551 {

    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if ((i==0 || chs[i-1]!='L')&&chs[i]=='L') {
                l=1;
                continue;
            }
            if (chs[i]=='A'){
                a++;
                if (a>=2) return false;
            }
            if (chs[i]=='L') {
                l++;
                if (l >= 3) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No551().checkRecord("ALLAPPL"));
    }

}
