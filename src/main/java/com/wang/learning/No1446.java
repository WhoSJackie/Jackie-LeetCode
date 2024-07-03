package com.wang.learning;

public class No1446 {
    public int maxPower(String s) {
        if(s==null||s==""){
            return 0;
        }
        int len=s.length();
        char ch=s.charAt(0);
        int num=1;
        int max=1;
        for (int i = 1; i < len; i++) {
            char temp=s.charAt(i);
            if(ch==temp){
                num++;
                max=Math.max(max,num);
                continue;
            }
            max=Math.max(max,num);
            num=1;
            ch=temp;
        }

        return max;
    }

    public static void main(String[] args) {
        System.out.println(new No1446().maxPower("jj"));
    }

}
