package com.wang.java_Learning.algorithm;

import java.util.concurrent.ThreadLocalRandom;

public class StreamSwitch {

    public static String selectColor(String[] colorArr,int[] weightArr){
        int length = colorArr.length;
        int totalWeight = 0;
        boolean sameWeight = true;
        // 判断是否是权重一致，理解成开关
        for (int i = 0; i < length; i++) {
            totalWeight+=weightArr[i];
            if (sameWeight && totalWeight!=weightArr[i]*(i+1)){
                sameWeight = false;
            }
        }
        // 权重不一致并且总权重>0
        if (!sameWeight && totalWeight>0){
            int offset = ThreadLocalRandom.current().nextInt(totalWeight);
            System.out.println(offset);
            for (int i = 0; i < length; i++) {
                if (offset<weightArr[i]){
                    return colorArr[i];
                }
            }
        }
        // 权重一致，则随机抽取
        return colorArr[ThreadLocalRandom.current().nextInt(length)];
    }

    public static void main(String[] args) {
        String[] colorArr = new String[]{"BLUE","GREEN"};
        int[] weightArr = new int[]{50,100};
        for (int i = 0; i < 20; i++) {
            System.out.println(selectColor(colorArr, weightArr));
        }
    }

}
