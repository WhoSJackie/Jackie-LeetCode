package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No1154 {
    private static final List<Integer> month01 = new ArrayList<Integer>(){{
        add(1);
        add(3);
        add(5);
        add(7);
        add(8);
        add(10);
        add(12);
    }};
    public int dayOfYear(String date) {
        String[] strs = date.split("-");
        if (strs.length!=3){
            return -1;
        }
        int year = Integer.parseInt(strs[0]);
        int month = Integer.parseInt(strs[1]);
        int day = Integer.parseInt(strs[2]);
        boolean flag = false;
        int res=0;
        if ((year%4==0&&year%100!=0)||(year%400==0)){
            flag = true;
        }
        for (int i=1;i<=month-1;i++){
            // 判断是否是闰年
            if (i==2){
                res= res+(flag?29:28);
                continue;
            }
            if (month01.contains(i)){
                res+=31;
            } else{
                res+=30;
            }
        }
        return res+day;
    }

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        new No1154().dayOfYear("2019-03-05");
        System.out.println("耗时->"+(System.currentTimeMillis()-startTime));
    }

}
