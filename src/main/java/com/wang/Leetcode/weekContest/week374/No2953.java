package com.wang.Leetcode.weekContest.week374;

public class No2953 {
    // 超时
    public int countCompleteSubstrings(String word, int k) {
        int res=0;
        int len = word.length();
        int[][][] mat = new int[len][len][26];
        boolean[][] vis = new boolean[len][len];
        // 初始化vis,mat数组
        for (int i = 0; i < len; i++) {
            mat[i][i][word.charAt(i)-'a']++;
            if (mat[i][i][word.charAt(i)-'a']==k){
                res++;
            }
            for (int j = 0; j < len; j++) {
                vis[i][j] = true;
            }
        }
        // 当k>1的情况
        int i=0,j=0,curLen=2,index=0;
        boolean flag;
        // 根据长度区间来逐级统计每个区间的字符数量
        while ((curLen<=len)){
            for (int x=0;x<len;x++){
                flag = true;
                j=x+curLen-1;
                if (j>=len) break;
                index=word.charAt(j)-'a';
                vis[x][j] = vis[x][j - 1] && (Math.abs(word.charAt(j) - word.charAt(j - 1)) <= 2);
                if (!vis[x][j]) continue;
                for (int y = 0; y < 26; y++) {
                    mat[x][j][y]=mat[x][j-1][y]+(y==index?1:0);
                }
                // 统计该范围内字符是否都符合k，并且相邻字符相差不超过2
                for (int y = 0; y < 26; y++) {
                    if (mat[x][j][y]!=0&&mat[x][j][y]!=k){
                        flag=false;
                        break;
                    }
                }
                if (flag&&vis[x][j]) res++;
            }
            curLen++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new No2953().countCompleteSubstrings("ba", 1));
    }
}
