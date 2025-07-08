package com.wang.java_Learning.StringUtils;


import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class StringGetBytes {

    public static void main(String[] args) {
        Charset charset=StandardCharsets.UTF_8;
        String str="中";
        byte[] bytes = str.getBytes(charset);
        String newStr=new String(bytes,0,bytes.length,charset);
        System.out.println(newStr);
    }
}
