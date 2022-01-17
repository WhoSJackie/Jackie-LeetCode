package com.wang.Leetcode;

public class No38 {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String str=countAndSay(n-1);
        //处理返回的上一个字符串
        StringBuilder sb=new StringBuilder();
        int count=1;
        int len=str.length()-1;
        for (int i = 0; i < len; i++) {
            if(str.charAt(i)==str.charAt(i+1)){
                count++;
            }
            else{
                sb.append(count).append(str.charAt(i));
                count=1;
            }
        }
        //处理最后一位
        if(len>0){
            if(str.charAt(len-1)==str.charAt(len)){
                sb.append(count).append(str.charAt(len));
            }
            else{
                sb.append("1"+str.charAt(len));
            }
        }
        else{
            sb.append("1"+str.charAt(len));
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        System.out.println(new No38().countAndSay(4));
    }
}
