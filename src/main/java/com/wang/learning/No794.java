package com.wang.learning;

public class No794 {

    public boolean validTicTacToe(String[] board) {
        int len=board.length;
        int sumx=0;
        int sumo=0;
        int[][] xwin=new int[4][3];
        int[][] owin=new int[4][3];

        //收集行列信息
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j)=='X'){
                    sumx++;
                    xwin[0][i]++;
                    xwin[1][j]++;
                    if(i==j){
                       xwin[2][0]++;
                    }
                    if(i==2-j){
                        xwin[3][0]++;
                    }
                } else if(board[i].charAt(j)=='O'){
                    sumo++;
                    owin[0][i]++;
                    owin[1][j]++;
                    if(i==j){
                        owin[2][0]++;
                    }
                    if(i==2-j){
                        owin[3][0]++;
                    }
                }
            }
        }

        //统计赢家
        int flagx=0;
        int flago=0;
        for (int i = 0; i < xwin.length; i++) {
            for (int i1 = 0; i1 < xwin[i].length; i1++) {
                if(xwin[i][i1]==3){
                    flagx++;
                }
                if(owin[i][i1]==3){
                    flago++;
                }
            }
        }


        // 必须出现 x数量>=o的数量 并且 x-o<=1
        if (sumx-sumo<0||sumx-sumo>1){
            return false;
        }

        //不可能出现两个赢家
        if(flagx>0&&flago>0){
            return false;
        }

        //如果出现赢家但双方数量不满足要求
        if(flagx>0&&flago==0&&(sumx-sumo!=1)||(flago==1&&flagx==0&&(sumo!=sumx))){
            return false;
        }


        return true;


    }

    public static void main(String[] args) {
        No794 n=new No794();
        String[] str={"OXX","XOX","OXO"};
        System.out.println(n.validTicTacToe(str));
    }
}
