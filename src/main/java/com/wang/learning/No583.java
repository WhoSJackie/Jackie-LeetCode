package com.wang.learning;

public class No583 {
    public static int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];

        for (int i = 1; i <= len1; i++) {
            char temp1=word1.charAt(i-1);
            for (int j = 1; j <= len2; j++) {
                char temp2=word2.charAt(j-1);
                if(temp1==temp2){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }

            }
        }

        return len1+len2-2*dp[len1][len2];
    }

    public static void main(String[] args) {
        System.out.println(minDistance("leetcode", "etco"));
    }
}
