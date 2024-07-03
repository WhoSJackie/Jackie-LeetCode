package com.wang.learning;


import java.util.HashMap;
import java.util.Map;

public class No423 {
    public String originalDigits(String s) {
        int[] res=new int[10];
        Map<Character,Integer> map=new HashMap<>();
        //统计各字符的数量
        for (char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }

        //凭借一个可以字母进行判断
        res[0]=map.getOrDefault('z',0);
        res[2]=map.getOrDefault('w',0);
        res[4]=map.getOrDefault('u',0);
        res[6]=map.getOrDefault('x',0);
        res[8]=map.getOrDefault('g',0);

        //使用前面结果加上两个字母可以进行判断
        res[3]=map.getOrDefault('h',0)-res[8];
        res[5]=map.getOrDefault('f',0)-res[4];
        res[7]=map.getOrDefault('v',0)-res[5];
        //根据前面三个数字判断
        res[1]=map.getOrDefault('o',0)-res[0]-res[2]-res[4];

        //单独处理9
        res[9]=map.getOrDefault('i',0)-res[5]-res[6]-res[8];

        StringBuilder sb=new StringBuilder();

        for(int i=0;i<res.length;i++){
            for(int j=0;j<res[i];j++){
                sb.append(i);
            }
        }

        return sb.toString();
    }
}
