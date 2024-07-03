package com.wang.learning;

import java.util.ArrayList;
import java.util.List;

public class No1592 {

    public String reorderSpaces(String text) {
        // 统计空格,收集单词
        int count=0;
        List<String> strs = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i)==' '){
                count++;
                if (sb.length()>0){
                    strs.add(sb.toString());
                    // 清空sb
                    sb.delete(0,sb.length());
                }
            } else{
                // 收集单词
                sb.append(text.charAt(i));
            }
        }
        if (sb.length()>0){
            strs.add(sb.toString());
        }
        StringBuilder sb1 = new StringBuilder();
        if (strs.size()==1){
            sb1.append(strs.get(0));
            for (int i = 0; i < count; i++) {
                sb1.append(" ");
            }
            return sb1.toString();
        }
        int len = strs.size()-1;
        // 计算空格如何均匀分割
        int a = count/(len);
        // 可能存在剩余空格
        int b = count%(len);

        for (int i = 0; i < strs.size(); i++) {
            sb1.append(strs.get(i));
            // 加空格
            if (i!=strs.size()-1){
                for (int i1 = 0; i1 < a; i1++) {
                    sb1.append(" ");
                }
            } else{
                for (int i2 = 0; i2 < b; i2++) {
                    sb1.append(" ");
                }
            }
        }

        return sb1.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No1592().reorderSpaces("hello  world"));

    }

}
