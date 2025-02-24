package com.wang.java_Learning;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringTest {

    public static String splitSoh(String str){
        String[] strs = str.split("");
        for (String s : strs) {
            System.out.print(s);
            System.out.print(" ");
        }
        return Arrays.stream(strs).collect(Collectors.joining());
    }

    public static void dictValueSqlScript(Integer dictitem,String item,String itemname,int startIndex){
        String[] strs = item.split("，");
        if (strs.length<=1) {
            strs = item.split(",");
        }
        int ix=startIndex;
        for (String str : strs) {
            System.out.println(String.format("insert into sys_dictvalue (DICTITEM, SUBITEM, SUBITEMNAME, MACRO) values (%d, '%s', '%s', null);",dictitem,String.valueOf(ix++),str));
        }
        System.out.println(String.format("insert into sys_dictindex (DICTITEM, ITEMNAME, LOADLEVEL, VALIDLEN, DISPFLAG, CTRLFLAG, DICTGROUPID, USERSETFLAG) values (%d, '%s', ' ', 1, ' ', ' ', 0, ' ');",dictitem,itemname));
    }


    public static void main(String[] args) {
//        splitSoh("zxd022\u00011\u00012\u00012;3\u0001测试022\u0001tyxy022\u00011;0\u00010\u00010\n" +
//                "zxd0221\u00011\u00012\u00012;3;1\u0001测试022\u0001tyxy022\u00011;0\u00010\u00010\n");
//        dictValueSqlScript(83051,"其中：本期新发生风险项目，2014年以来累计新发生风险项目，本期化解的风险项目，2014年以来累计化解的风险项目","风险要素表类别",1);
        char s = 'a';
        System.out.println(s>='A'&&s<='Z');
    }


}
