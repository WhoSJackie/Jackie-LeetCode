package com.wang.Leetcode.get_offer;

public class Offer20 {

    public boolean isNumber(String s) {
        char[] chars = s.trim().toCharArray();
        boolean numSeen = false;
        boolean exp = false;
        boolean dot = false;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i]>='0'&&chars[i]<='9') numSeen = true;

            //+-号只能在第一个或者E,e之后
            else if (chars[i]=='+'||chars[i]=='-'){
                if (!((i>0&&(chars[i-1]=='e'||chars[i-1]=='E'))||(i==0))) {
                    return false;
                }
            }

            // 点只能在数字之间或者前面没有E，e的情况
            else if (chars[i]=='.'){
                if (dot||exp) {
                    return false;
                }
                dot = true;
            }
            // E,e只能在数字之后
            else if (chars[i]=='e'||chars[i]=='E'){
                if (!(!exp||(i>0&&(chars[i-1]>='0'&&chars[i-1]<='9')))){
                    return false;
                }
                exp=true;
            } else{
                return false;
            }
        }
        return numSeen;
    }

}
