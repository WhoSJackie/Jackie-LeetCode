package com.wang.Leetcode;

public class No393 {

    public boolean validUtf8(int[] data) {
        int len  = data.length;
        // 判断第一个字符的1个数
        for (int i=0;i<len;){
            int cnt=0,j=7;
            while (j>=0&&((data[i]>>j&1)==1)) j--;
            cnt = 7-j;
            if (i+cnt-1>len-1) return false;
            if (cnt==1 || cnt>4) return false;
            for (int k=i+1;k<i+cnt;k++){
                if ((((data[k]>>7)&1)==1) && (((data[k]>>6)&1)==0)) continue;
                else return false;
            }
            if (cnt==0) i++;
            else i = i+cnt;
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(new No393().validUtf8(new int[]{39,89,227,83,132,95,10,0}));
    }

}
