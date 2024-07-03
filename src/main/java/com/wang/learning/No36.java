package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No36 {
    public boolean isValidSudoku(char[][] board) {
        if(!isValidBox(board)||!isValidCol(board)||!isValidRow(board)){
            return false;
        }
        return true;

    }

    public boolean isValidRow(char[][] board){
        List<Character> list1;
        for (int i = 0; i < 9; i++) {
            list1=new ArrayList<>();
            for (int j = 0; j < 9; j++) {
                char tmp=board[i][j];
                if(tmp!='.'){
                    if(list1.contains(tmp)){
                        return false;
                    }
                    list1.add(tmp);
                }
            }
        }
        return true;
    }

    public boolean isValidCol(char[][] board){
        List<Character> list2;
        for (int j = 0; j < 9; j++) {
            list2=new ArrayList<>();
            for (int i = 0; i < 9; i++){
                char tmp=board[i][j];
                if(tmp!='.'){
                    if(list2.contains(tmp)){
                        return false;
                    }
                    list2.add(tmp);
                }
            }
        }
        return true;
    }

    public boolean isValidBox(char[][] board){
        for (int i = 0; i < 9; i++) {
            if(!isValidChildBox(createBox(board,i))){
                return false;
            }
        }
        return true;
    }


    public char[][] createBox(char[][] board,int index){
        int x= index/3*3;
        int y= (index%3)*3;
        char[][] s=new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                s[i][j]=board[x+i][y+j];
            }
        }
        return s;
    }

    public boolean isValidChildBox(char[][] board1){
        List<Character> list=new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char tmp=board1[i][j];
                if(tmp!='.'){
                    if(list.contains(tmp)){
                        return false;
                    }
                    else{
                        list.add(tmp);
                    }
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        No36 n=new No36();
        char[][] s={{'.','.','4','.','.','.','6','3','.'},{'.','.','.','.','.','.','.','.','.'},{'5','.','.','.','.','.','.','.','.'},
                    {'.','.','.','5','6','.','.','.','.'},{'4','.','3','.','.','.','.','.','.'},{'.','.','.','7','.','.','.','.','.'},
                    {'.','.','.','5','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'},{'.','.','.','.','.','.','.','.','.'}};
        System.out.println(n.isValidSudoku(s));
    }


    public boolean isValidSudoku2(char[][] board){
        //存放行的每个数出现次数
        int[][] row=new int[9][9];
        //存放列的每个数出现次数
        int[][] col=new int[9][9];
        //存放小方格中每个数出现次数
        int[][] box=new int[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
               char tmp=board[i][j];
               if(tmp!='.'){
                  int num1=++row[i][tmp-'1'];
                  int num2=++col[j][tmp-'1'];
                  int num3=++box[(i/3)*3+j/3][tmp-'1'];
                  if(num1>1||num2>1||num3>1){
                      return false;
                  }
               }
            }
        }

        return true;
    }
}
