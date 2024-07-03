package com.wang.javaL.util;

public class StringUtils {

    public static boolean isEmpty(String s){
        if(s==null||s.length()==0){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
//        String a = "a";
//        List<String> strs = Arrays.asList(a.split(","));
//        for (String str : strs) {
//            System.out.println(str);
//        }
        String str = "true";
        Boolean flag = Boolean.parseBoolean(str);
        if (flag){
            System.out.println(flag);
        }

    }
}
