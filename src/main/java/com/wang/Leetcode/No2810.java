package com.wang.Leetcode;

/**
 * No2810 故障键盘
 */
public class No2810 {

    public String finalString(String s) {
        char[] chs = s.toCharArray();
        // 最后一个i之前的位置
        int cur = 0;
        boolean flag = false;
        for (int i = 0; i < chs.length; i++) {
            if (chs[i]=='i' && i>0){
                if (!flag){
                    cur = i-1;
                }
                flag = true;
                // 进行反转
                for (int j=0;j<=cur/2;j++){
                    char temp = chs[j];
                    chs[j] = chs[cur-j];
                    chs[cur-j] = temp;
                }
            }
            else{
                flag = false;
            }
        }
        StringBuilder sb  =new StringBuilder();
        for (char ch : chs) {
            if (ch!='i'){
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new No2810().finalString("string"));
    }

}
