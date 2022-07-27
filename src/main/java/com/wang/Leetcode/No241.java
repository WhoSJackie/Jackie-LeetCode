package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No241 {
    char[] array;
    public List<Integer> diffWaysToCompute(String expression) {
        if (expression==null||expression.trim().length()<=0){
            return Collections.emptyList();
        }
        char ch = expression.charAt(0);
        if (ch=='*'||ch=='+'||ch=='-'){
            return Collections.emptyList();
        }

        array = expression.toCharArray();
        return dfs(0,array.length-1);

    }

    private List<Integer> dfs(int l,int r){
        List<Integer> res = new ArrayList<>();

        for (int i=l;i<r;i++){
            if(array[i]>='0'&&array[i]<='9') continue;
            List<Integer> r1 = dfs(l,i-1);
            List<Integer> r2 = dfs(i+1,r);
            for (Integer i1 : r1) {
                for (Integer i2 : r2) {
                    int d=0;
                    if (array[i]!='+'&&array[i]!='-'&&array[i]!='*'){
                        return res;
                    }
                    if (array[i]=='+'){
                        d = i1+i2;
                    } else if(array[i]=='-'){
                        d = i1-i2;
                    } else{
                        d= i1*i2;
                    }
                    res.add(d);
                }
            }
        }

        // 说明是纯数字
        int temp = 0;
        if (res.isEmpty()){
            for (int i=l;i<r;i++){
                temp=temp*10+(array[i]-'0');
            }
            res.add(temp);
        }
        return res;
    }






}
