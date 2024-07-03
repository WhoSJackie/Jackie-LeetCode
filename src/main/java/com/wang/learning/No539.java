package com.wang.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class No539 {
    public int findMinDifference(List<String> timePoints) {
        if(timePoints==null||timePoints.size()<=0){
            return 0;
        }
        List<Integer> res=new ArrayList<>();
        int index=0;
        for (String timePoint : timePoints) {
            String[] strs=timePoint.split(":");
            if (strs.length!=2){
                continue;
            }
            // 将时间换算为分钟
            int h1=strs[0].charAt(0)-'0';
            int h2=strs[0].charAt(1)-'0';
            int m1=strs[1].charAt(0)-'0';
            int m2=strs[1].charAt(1)-'0';
            int h=10*h1+h2;
            int m=10*m1+m2;
            int totalTime=60*h+m;
            res.add(totalTime);
            res.add(totalTime+24*60);
        }
        Collections.sort(res);
        int min=Integer.MAX_VALUE;
        //遍历找到最小值
        for (int i = 0; i < res.size()-1; i++) {
            min=Math.min(min,res.get(i+1)-res.get(i));
        }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(new No539().findMinDifference(Arrays.asList("05:31","22:08","00:35")));
    }
}
