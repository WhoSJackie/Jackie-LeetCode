package com.wang.java_Learning.algorithm.trafficSwitch;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class TrafficSwitch {

    public static String selectColor(String[] colorArr,int[] weightArr){
        int length = colorArr.length;
        int totalWeight = 0;
        boolean sameWeight = true;
        // 判断权重是否一致
        for (int i = 0; i < length; i++) {
            totalWeight+=weightArr[i];
            if (sameWeight && totalWeight!=weightArr[i]*(i+1)){
                sameWeight = false;
            }
        }
        // 权重不一致返回
        if (!sameWeight && totalWeight>0){
            int offset = ThreadLocalRandom.current().nextInt();
            System.out.println(offset);
            for (int i = 0; i < length; i++) {
                if (offset<weightArr[i]){
                    return colorArr[i];
                }
            }
        }
        // 权重一致返回
        return colorArr[ThreadLocalRandom.current().nextInt(length)];
    }

    public static void main(String[] args) {

    }




}
