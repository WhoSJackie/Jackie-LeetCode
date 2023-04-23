package com.wang.Leetcode.get_offer;

public class Offer58I {

    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i=strs.length-1;i>=0;i--){
            if (strs[i].equals("")) continue;
            sb.append(strs[i].trim());
            if (i!=0){
                sb.append(" ");
            }

        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Offer58I().reverseWords("a good   example"));
    }

}
