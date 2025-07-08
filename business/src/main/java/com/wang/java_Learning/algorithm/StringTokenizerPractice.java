package com.wang.java_Learning.algorithm;

import java.util.Locale;

public class StringTokenizerPractice {

    public static void main(String[] args) {
        // new StringTokenizerPractice().distanceBetweenBusStops(new int[]{1,2,3,4},0,1);

        StringBuilder sb = new StringBuilder();
        sb.append("A").append("|").append("B").append("|");
        System.out.println(sb.toString().toLowerCase(Locale.ROOT));
    }

    public int distanceBetweenBusStops(int[] distance, int start, int destination){
        int n = distance.length;
        if (n==1||start==destination){
            return 0 ;
        }
        // 计算路径总和
        int sum=0;
        for (int dis : distance) {
            sum+=dis;
        }
        // 顺时针
        int s=start;
        int e=destination;
        if (start>destination){
            e = start;
            s = destination;
        }
        int temp = 0;
        for (int i=s;i<e;i++){
            temp+=distance[i];
        }
        return Math.min(temp, (sum - temp));
    }


}
