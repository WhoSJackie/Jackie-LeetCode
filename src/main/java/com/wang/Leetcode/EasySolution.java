package com.wang.Leetcode;


public class EasySolution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb  =new StringBuilder();
        while (columnNumber!=0){
            columnNumber--;
            sb.append((char)('A'+columnNumber%26));
            columnNumber = columnNumber/26;
        }
        return sb.reverse().toString();
    }


    public static void main(String[] args) {
        System.out.println(new EasySolution().convertToTitle(27));
    }

}
