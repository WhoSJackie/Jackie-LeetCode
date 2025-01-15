package com.wang.java_Learning.Convertor;

public class binaryConvertor {

    public static String getBinary(int num){
        StringBuffer sb=new StringBuffer();
        while(num!=0){
            sb.append(num%2);
            num/=2;
        }
        return sb.toString();
    }


    public static void main(String[] args) {
        System.out.println(getBinary(25907));
    }
}
