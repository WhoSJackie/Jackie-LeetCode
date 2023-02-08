package com.wang.Leetcode;


public class No1694 {
    public String reformatNumber(String number) {
        StringBuilder sb = new StringBuilder();
        // 收集数字字符
        for (int i = 0; i < number.length(); i++) {
            if(number.charAt(i)>='0'&&number.charAt(i)<='9'){
                sb.append(number.charAt(i));
            }
        }


        // 进行三个字母为一组的组合，剩下的为三个或者两个数字，不应该剩余一个
        int i = sb.length()/3;
        int j = sb.length()%3;
        if (j==1){
            i=i-1;
        }
        i = i*3;
        int count=0;
        StringBuilder res = new StringBuilder();
        int index=0;
        while (index<i) {
            if (count==3){
                res.append("-");
                count=0;
            }
            res.append(sb.charAt(index));
            count++;
            index++;
        }
        if (index<sb.length()){
            res.append("-");
            count=0;
        }
        while(index<sb.length()) {
            if (count==2){
                res.append("-");
                count=0;
            }
            res.append(sb.charAt(index));
            count++;
            index++;
        }

        return res.charAt(0)=='-'?res.substring(1):res.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No1694().reformatNumber("12"));
    }
}
