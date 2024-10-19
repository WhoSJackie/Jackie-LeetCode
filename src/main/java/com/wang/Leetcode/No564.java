package com.wang.Leetcode;

import java.util.HashSet;
import java.util.Set;

public class No564 {

    public String nearestPalindromic(String n) {
        int len  = n.length();
        Set<Long> res = new HashSet<>();
        res.add((long)Math.pow(10,len-1)-1);
        res.add((long)Math.pow(10,len)+1);
        long num = Long.parseLong(n);
        long t = Long.parseLong(n.substring(0,(len+1)/2));
        // 通过前半段生成回文数
        for (long i=t-1;i<=t+1;i++){
            long tmp = getNum(i,len%2==0);
            if (tmp!=num) res.add(tmp);
        }
        // 比较距离
        long ans = -1;
        for (Long re : res) {
            if (ans==-1) ans = re;
            else if (Math.abs(re-num)<Math.abs(num-ans)) ans = re;
            else if (Math.abs(re-num)==Math.abs(num-ans) && re<ans) ans = re;
        }
        return String.valueOf(ans);
    }

    long getNum(long t,boolean isEven){
        StringBuilder sb = new StringBuilder();
        sb.append(t);
        int n = sb.length();
        int idx=isEven?n-1:n-2;
        while (idx>=0){
            sb.append(sb.charAt(idx--));
        }
        return sb.length()>19?-1:Long.parseLong(sb.toString());
    }

    public static void main(String[] args) {
        System.out.println(new No564().nearestPalindromic("123"));
    }


}
