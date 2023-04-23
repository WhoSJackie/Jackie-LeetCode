package com.wang.Leetcode;

import java.util.Arrays;

public class No2347 {

    String[] res = {"Flush","Three of a Kind","Pair","High Card"};

    public String bestHand(int[] ranks, char[] suits) {
        Arrays.sort(ranks);
        char temp = suits[0];
        int r = ranks[0];
        int i=1;
        int counts = 1;
        int countr = 1;
        int max = 0;
        while (i<suits.length){
            if (temp == suits[i]) {
                counts++;
            }
            if (r == ranks[i]){
                countr++;
            } else{
                r = ranks[i];
                max = Math.max(countr,max);
                countr=1;
            }
            i++;
        }
        max = Math.max(countr,max);

        // 同花
        if (counts == 5) return res[0];

        // 三条
        if (max >=3) return res[1];

        // 对子
        if (max>=2) return res[2];

        // 高牌
        return res[3];
    }

    public static void main(String[] args) {
        int[] ranks = {4,4,2,4,4};
        char[] suits = {'d','a','a','b','c'};
        System.out.println(new No2347().bestHand(ranks, suits));
    }

}
