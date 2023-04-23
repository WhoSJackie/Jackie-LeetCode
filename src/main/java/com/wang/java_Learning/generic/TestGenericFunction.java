package com.wang.java_Learning.generic;

public class TestGenericFunction {

    public static <T> void getStr(T[] param){
        for (T s:param){
            System.out.printf("%s",s);
            System.out.println("");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        TestGenericFunction.getStr(new String[]{"a","b","c"});
    }


}
