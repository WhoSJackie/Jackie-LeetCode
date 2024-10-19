package com.wang.Leetcode;

public class No3174 {

    public String clearDigits(String s) {
        StringBuilder sb = new StringBuilder();
        char[] chs = s.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            if (chs[i]>='0'&&chs[i]<='9'){
                chs[i]='-';
                // 寻找左边第一个字母
                int tmp = i-1;
                while (tmp>=0){
                    if (chs[tmp]!='-' && (chs[tmp]>'9'|| chs[tmp]<'0')){
                        chs[tmp] = '-';
                        break;
                    }
                    tmp--;
                }
            }
        }
        // 统计不是-的
        for (int i = 0; i < chs.length; i++) {
            if (chs[i]!='-') sb.append(chs[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No3174().clearDigits("cd34"));
    }


}
