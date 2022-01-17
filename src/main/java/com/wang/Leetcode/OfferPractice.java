package com.wang.Leetcode;



public class OfferPractice {
    public String reverseLeftWords(String s, int n) {
        StringBuilder sb=new StringBuilder();
        String temp=s.substring(0,n+1);
        sb.append(s,n,s.length()+1);
        sb.append(temp);
        return sb.toString();
    }

    public static void main(String[] args) {

    }
}
