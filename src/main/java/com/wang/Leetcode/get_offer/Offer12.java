package com.wang.Leetcode.get_offer;

public class Offer12 {
    char[][] arr;
    boolean[][] vis;
    char[] str;
    int[][] dic = {{1,0},{-1,0},{0,1},{0,-1}};
    public boolean exist(char[][] board, String word) {
        arr = board;
        vis = new boolean[board.length][board[0].length];
        str = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (dfs(i,j,0)) return true;
            }
        }
        return false;
    }

    public boolean dfs(int i,int j,int cnt){
        if (cnt==str.length) return true;
        if (i<0||i>=arr.length||j<0||j>=arr[0].length||vis[i][j]) return false;
        vis[i][j] = true;
        boolean flag = false;
        if (str[cnt]!=arr[i][j]) {
            vis[i][j] = false;
            return false;
        }
        for (int[] d:dic){
            flag = flag||dfs(i+d[0],j+d[1],cnt+1);
        }
        vis[i][j] = false;
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'a','b'}};
        System.out.println(new Offer12().exist(board, "ba"));
    }

}
