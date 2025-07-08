package com.wang.Leetcode.offerII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Offer004 {

    public int singleNumber(int[] nums) {
        int res=0;
        //法一额外数组法
//        int[] arr = new int[32];
//        // 统计每个位置上1的个数
//        int cnt=0;
//        for (int num : nums) {
//            cnt=0;
//            while (num!=0){
//                if ((num&1)==1) {
//                    arr[cnt]++;
//                }
//                cnt++;
//                num = num>>>1;
//            }
//        }

        // 对每一个不为零的位置上面进行取模3运算，为零的位置则是零
//        int muti=1;
//        for (int i : arr) {
//            res += muti*(i%3);
//            muti = muti*2;
//        }

//        for (int i=0;i<arr.length;i++){
//            res = res|((arr[i]%3)<<i);
//        }

        // 法二原地统计法
        for (int i=0;i<=32;i++){
            int temp=0;
            for (int num : nums) {
                temp+=(num>>>i)&1;
            }

            res|=(temp%3)<<i;

        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer004().singleNumber(new int[]{0,1,0,1,0,1,99}));
    }

}
