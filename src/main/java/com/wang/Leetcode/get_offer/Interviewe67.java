package com.wang.Leetcode.get_offer;

public class Interviewe67 {

    public int strToInt(String str) {
        char[] trimStr = str.trim().toCharArray();
        long num = 0;
        boolean flag = true;
        boolean numSeen = false;
        for (int i=0;i<trimStr.length;i++){
            if (trimStr[i]=='+'||trimStr[i]=='-'){
                if (i!=0&&!numSeen) return 0;
                if (i==0) flag = trimStr[i] == '+';
            }
            else if ((trimStr[i]<'0'||trimStr[i]>'9')){
                if (i==0) {
                    return 0;
                } else {
                    return flag?Long.valueOf(num).intValue():Long.valueOf(-num).intValue();
                }
            } else{
                num = num*10+(trimStr[i]-'0');
                if (flag){
                    if (num>Integer.MAX_VALUE) return Integer.MAX_VALUE;
                } else{
                    long temp = -num;
                    if (temp<Integer.MIN_VALUE) return Integer.MIN_VALUE;
                }
                numSeen = true;
            }
        }
        return flag?Long.valueOf(num).intValue():Long.valueOf(-num).intValue();
    }

}
