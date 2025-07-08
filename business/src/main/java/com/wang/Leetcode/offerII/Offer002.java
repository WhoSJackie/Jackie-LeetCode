package com.wang.Leetcode.offerII;

public class Offer002 {

    public String addBinary(String a, String b) {
        // 位运算模拟版本
//        if (a.equals("0")) return b;
//        if (b.equals("0")) return a;
//        StringBuilder add = new StringBuilder();
//        StringBuilder carry = new StringBuilder();
//        while (true){
//            int i=a.length()-1;
//            int j=b.length()-1;
//            if (i>j){
//                b = appendZero(b,i-j);
//            } else if (i<j){
//                a = appendZero(a,j-i);
//            }
//            i=0;
//            while (i<a.length()){
//                add.append((a.charAt(i)-'0')^(b.charAt(i)-'0'));
//                carry.append((a.charAt(i)-'0')&(b.charAt(i))-'0');
//                i++;
//            }
//            if (!isZero(carry.toString())){
//                carry.append('0');
//            } else{
//                break;
//            }
//            a = add.toString();
//            b = carry.toString();
//            add.setLength(0);
//            carry.setLength(0);
//        }
//        int temp = 0;
//        while (temp<add.length()&&add.charAt(temp)=='0'){
//            temp++;
//        }
//        return add.substring(temp);

        // 正常二进制进位计算法
        int carry=0;
        int temp = 0;
        StringBuilder sb  =new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        while (i>=0&&j>=0){
            int aa = a.charAt(i)-'0';
            int bb = b.charAt(i)-'0';
            temp = aa+bb+carry;
            sb.insert(0,temp%2);
            carry = (temp)/2;
            i--;
            j--;
        }
        return sb.toString();
    }

    public String appendZero(String s,int len){
        int index=0;
        StringBuilder sb = new StringBuilder(s);
        while (index<len){
            sb.insert(0,'0');
            index++;
        }
        return sb.toString();
    }

    public boolean isZero(String s){
        char[] chs = s.toCharArray();
        for (int i=0;i<s.length();i++){
            if (chs[i]!='0') return false;
        }
        return true;
    }

    public static void main(String[] args) {
         System.out.println(new Offer002().addBinary("0", "0"));
//        String a = "1";
//        String b = "0";
//        System.out.println((a.charAt(0)-'0')&(b.charAt(0)-'0'));
    }

}
