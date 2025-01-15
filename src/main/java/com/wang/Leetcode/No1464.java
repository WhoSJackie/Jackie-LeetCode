package com.wang.Leetcode;

public class No1464 {

    public int maximumValue(String[] strs) {
        int len = strs.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            // 处理每个字符串的值
            String str = strs[i];
            max = Math.max(getVal(str),max);
        }
        return max;
    }

    // 法一 直接强转，不报错则为数字
    private int strConvertNum(String val){
        int a = val.length();
        try{
            a = Integer.parseInt(val);
        } catch (Exception e){

        }
        return a;
    }

    private int getVal(String val){
        int temp=0;
        int res = val.length();
        char[] chArr = val.toCharArray();
        int len = chArr.length;
        for (int i=0;i<len;i++){
            if (chArr[i]>='a' && chArr[i]<='z'){
                return res;
            } else{
                temp = temp*10+(chArr[i]-'0');
            }
        }
        return temp;
    }

    public static void main(String[] args) {
        System.out.println(new No1464().maximumValue(new String[]{"ab123", "345"}));
    }

}
