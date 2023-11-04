package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1156 {

    public int maxRepOpt1(String text) {
        Map<Character,Integer> map = new HashMap<>();
        int len = text.length();
        char[] chs = text.toCharArray();
        int max=0;
        // 统计每个字符的出现个数
        for (int i = 0; i < len; i++) {
            map.put(chs[i],map.getOrDefault(chs[i],0)+1);
        }

        for (int i = 0; i < len;) {
            int j=i;
            // 1.找到连续的字符
            while (j<len&&chs[i]==chs[j]){
                j++;
            }
            int count = j-i;

            // 2.如果count<总出现的次数，之前之后是否有空位,有就加1
            if (count<map.getOrDefault(chs[i],0)&&(i>0||j<len)){
                max = Math.max(max,count+1);
            }
            // 3.找到j+1开始是否存在第二段字符串
            int k = j+1;
            while (k<len&&chs[k]==chs[i]){
                k++;
            }
            max = Math.max(max,Math.min(k-i,map.getOrDefault(chs[i],0)));
            i = j;
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new No1156().maxRepOpt1("aaabaaa"));;
    }

}
