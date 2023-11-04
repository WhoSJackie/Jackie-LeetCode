package com.wang.Leetcode;

import java.util.Arrays;

public class No1054 {

    // 法一 计数+排序
//    public int[] rearrangeBarcodes(int[] barcodes) {
//        int len = barcodes.length;
//        int mx = 0;
//        Integer[] t = new Integer[len];
//        // 找到最大的数
//        int idx = 0;
//        for (int i:barcodes){
//            t[idx++] = i;
//            mx = Math.max(mx,i);
//        }
//
//        int[] cnt = new int[mx+1];
//        for (int i:barcodes){
//            cnt[i]++;
//        }
//        Arrays.sort(t,(a, b) -> cnt[a]==cnt[b]?(a-b):cnt[b]-cnt[a]);
//        int[] res = new int[len];
//        int index = 0;
//        for (int k=0;k<2;k++){
//            for (int i=k;i<len;i+=2){
//                res[i] = t[index++];
//            }
//        }
//        return res;
//    }

    // 法二 左右横跳
    public int[] rearrangeBarcodes(int[] barcodes) {
        int len = barcodes.length;
        int i=0;
        int j = i+1;
        boolean flag = false;
        a:{
            while (j<len){
                if (barcodes[i]==barcodes[j]){
                    // 向后找到一个不一样的
                    int tmp = j+1;
                    while (tmp<len&&barcodes[tmp]==barcodes[i]){
                        tmp++;
                    }
                    // 如果是非正常退出
                    if (tmp>=len){
                        flag = true;
                        break a;
                    } else{
                        // 如果是找到了不一样的，就进行交换
                        int temp = barcodes[j];
                        barcodes[j] = barcodes[tmp];
                        barcodes[tmp] = temp;
                    }
                }
                i++;
                j++;
            }
        }

        if (flag){
            // 如果存在一趟遍历无法处理的情况，那么倒着再遍历一遍
            i = len-1;
            j = i-1;
            b:{
                while (j>=0&&i>=0){
                    if (barcodes[i]==barcodes[j]){
                        int tmp = j-1;
                        while (tmp>=0&&barcodes[tmp]==barcodes[i]){
                            tmp--;
                        }
                        // 如果是非正常退出
                        if (tmp<0){
                            flag = true;
                            break b;
                        } else{
                            // 如果是找到了不一样的，就进行交换
                            int temp = barcodes[j];
                            barcodes[j] = barcodes[tmp];
                            barcodes[tmp] = temp;
                        }
                    }
                    i--;
                    j--;
                }
            }
        }

        return barcodes;
    }


}
