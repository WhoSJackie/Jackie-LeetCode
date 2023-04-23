package com.wang.Leetcode.weekContest.week344;

public class No6362 {

    public int findTheLongestBalancedSubstring(String s) {
        char[] ch = s.toCharArray();
        int l = 0;
        int r = 0;
        int max=0;
        int curZero = 0;
        int curOne = 0;
        while (l<=r&&r<ch.length){
            while (ch[l]!='0') {
                l++;
                if (l>=ch.length) return max;
            }
            r = l;
            while (ch[r]!='1') {
                if (ch[r++]=='0') curZero++;
                if (r>=ch.length) return max;
            }
            while (r<ch.length&&ch[r]=='1') {
                curOne++;
                r++;
            }
            max = Math.max(max,Math.min(curOne,curZero)*2);
            if (r>=ch.length) break;
            // 重新搜索解，找到最优解
            if (ch[r]=='0') {
                l = r;
                curZero=0;
                curOne=0;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        System.out.println(new No6362().findTheLongestBalancedSubstring("011"));
    }

}
