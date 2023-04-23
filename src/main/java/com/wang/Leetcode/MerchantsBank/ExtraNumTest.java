package com.wang.Leetcode.MerchantsBank;

import java.util.ArrayList;
import java.util.List;

public class ExtraNumTest {

    public ArrayList<Integer> extraNum (String s) {
        ArrayList<Integer> res = new ArrayList<>();
        char[] ch = s.toCharArray();
        int len = ch.length;
        int temp=0;
        boolean flag = false;
        for (int i=0;i<len;i++){
            while (i<len&&(ch[i]>='0'&&ch[i]<='9')){
                temp = temp*10+(ch[i]-'0');
                i++;
                flag = true;
            }
            if (flag){
                res.add(temp);
                temp = 0;
                flag = false;
            }
        }

        return res;
    }

}
