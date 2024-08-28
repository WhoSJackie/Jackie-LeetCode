package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No043 {

    public String multiply(String num1, String num2) {
        if ("0".equals(num1)||"0".equals(num2)) return "0";
        if (num1.length()<num2.length()){
            String temp  =num1;
            num1 = num2;
            num2 = temp;
        }
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        StringBuilder sb = null;
        List<char[]> addStrs = new ArrayList<>();
        int add = 0;
        int max = 0;
        // 进行乘法计算
        for (int i = n2.length-1; i >=0; i--) {
            sb = new StringBuilder();
            for (int j = n1.length-1; j >=0; j--) {
                int temp = (n1[j]-'0')*(n2[i]-'0');
                // 判断进位
                temp+=add;
                if (temp/10!=0) {
                    add = temp/10;
                } else{
                    add = 0;
                }
                sb.append(temp%10);
            }
            // 加上最后的进位
            if (add!=0){
                sb.append(add);
                add=0;
            }
            // 后置位补零
            sb = sb.reverse();
            for (int x = 0; x < n2.length-1-i; x++) {
                sb.append('0');
            }
            char[] tmpChs = sb.toString().toCharArray();
            max = Math.max(tmpChs.length,max);
            addStrs.add(tmpChs);
        }
        Deque<Character> stack = new LinkedList<>();
        // 进行加法计算
        add=0;
        for (int i = max-1; i >=0; i--) {
            int tmp = 0;
            tmp+=add;
            for (char[] str : addStrs) {
                if (i-(max-str.length)>=0){
                    tmp+=str[i-(max-str.length)]-'0';
                }
            }
            if (tmp/10!=0) add=tmp/10;
            else add=0;
            stack.push((char)('0'+tmp%10));
        }
        // 加上最后的进位
        if (add!=0) stack.push((char)('0'+add));
        sb = new StringBuilder();
        while (!stack.isEmpty()){
            sb.append(stack.poll());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No043().multiply("9133", "0"));
    }

}
