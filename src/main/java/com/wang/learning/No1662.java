package com.wang.learning;


public class No1662 {

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int i=0,j=0,m=0,n=0;
        int len1 = word1.length;
        int len2 = word2.length;
        while (i<len1&&j<len2){
            if (word1[i].charAt(m++)!=word2[j].charAt(n++)) return false;
            if (m==word1[i].length()){
                i++;
                m=0;
            }
            if (n==word2[j].length()){
                j++;
                n=0;
            }
        }

        return (i==len1)&&(j==len2);
    }

}
