package com.wang.learning;

public class No1816 {
    public String truncateSentence(String s, int k) {
        if(s==null||s.length()==0){
            return s;
        }
        String[] str=s.split(" ");
        StringBuilder sb=new StringBuilder();
        int i=0;
        for (String s1 : str) {
            if(i<k-1){
                sb.append(s1).append(" ");
                i++;
                continue;
            }
            if(i==k-1){
                sb.append(s1);
                i++;
                continue;
            }
            break;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s="the poem is so romantic";
        No1816 n=new No1816();
        System.out.println(n.truncateSentence(s, 3));
    }
}
