package com.wang.Leetcode.HUAWEI;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayCenterPos {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int[] s = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
        // 计算前缀乘积
        int[] res = new int[s.length];
        res[0] = s[0];
        for (int i=1;i<s.length;i++){
            res[i] = res[i-1]*s[i];
        }

        int index=0;
        int max = res.length-1;
        boolean flag = false;
        // 遍历数组，找到中间位置
        for (int i=0;i<s.length;i++){
            int left = res[i]/s[i];
            int right = res[max]/res[i];
            if (left==right) {
                flag = true;
                index = i;
                break;
            }
        }
        System.out.println(flag?index:-1);
    }

}
