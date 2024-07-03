package com.wang.learning;

public class No1768 {

    public String mergeAlternately(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder sb = new StringBuilder();
        int index=0;
        while((index<len1)&&(index<len2)){
            sb.append(word1.charAt(index)).append(word2.charAt(index));
            index++;
        }
        if (index<len1){
            sb.append(word1.substring(index));
        }
        if (index<len2){
            sb.append(word2.substring(index));
        }
        return sb.toString();
    }

}
