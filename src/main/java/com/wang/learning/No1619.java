package com.wang.learning;

import java.util.Arrays;

public class No1619 {

    public double trimMean(int[] arr) {
        Arrays.sort(arr);
        double count = Math.floor(arr.length*0.05);
        double res = 0;
        // 将arr中前5%和后5%的数字置为零，不参与计算
        for (int i=0;i<count;i++){
            arr[i]=0;
            arr[arr.length-1-i]=0;
        }

        // 计算平均值
        for (int i : arr) {
            res+=i;
        }
        return res/((arr.length)-2*count);

    }

    public static void main(String[] args) {
        System.out.println(new No1619().trimMean(new int[]{1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3}));
    }

}
