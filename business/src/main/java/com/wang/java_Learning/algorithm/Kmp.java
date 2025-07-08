package com.wang.java_Learning.algorithm;

public class Kmp {
    public static int kmpSubstr(String mainStr,String matchStr){
        if (matchStr.length()==0) return -1;
        mainStr = " "+mainStr;
        matchStr = " "+matchStr;
        char[] mainChs = mainStr.toCharArray();
        char[] matchChs = matchStr.toCharArray();
        int n = mainChs.length-1,m = matchChs.length-1;
        int[] next = new int[m+1];
        for (int i=2,j=0;i<=m;i++){
            while (j>0 && matchChs[i]!=matchChs[j+1]) j = next[j];
            if (matchChs[i] == matchChs[j+1]) j++;
            next[i] = j;
        }
        for (int i=1,j=0;i<=n;i++){
            while (j>0 && mainChs[i]!=matchChs[j+1]) j = next[j];
            if (mainChs[i] == matchChs[j+1]) j++;
            if (j==m) return i-m;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(kmpSubstr("abacabcabb", "abcabb"));
    }


}
