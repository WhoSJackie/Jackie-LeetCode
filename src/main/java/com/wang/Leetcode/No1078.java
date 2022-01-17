package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * author:Jackie Wang
 * time 2021/12/26 10:27
 */
public class No1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] str=text.trim().split(" ");
        List<String> list=new ArrayList<>();

        int index=0;
        while(index<str.length){
            // 如果发现第一个词，开始匹配流程
            if (first.equals(str[index])){
                if (index+1<str.length-1){
                    if (second.equals(str[index+1])){
                        index=index+2;
                        list.add(str[index]);
                        // 从第二个词开始匹配，以免遇上第一第二的词相同的情况,就可能遗漏
                        index--;
                        continue;
                    }
                } else{
                    break;
                }
            }
            index++;
        }

        String[] res=new String[list.size()];

        int x=0;
        for (String s : list) {
            res[x]=s;
            x++;
        }

        return res;
    }

    public static void main(String[] args) {
        String[] ocurrences = new No1078().findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa"
                ,"kcyxdfnoa"
                ,"jkypmsxd");
        for (String ocurrence : ocurrences) {
            System.out.println(ocurrence);
        }
    }
}
