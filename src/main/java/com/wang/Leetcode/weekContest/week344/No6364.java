package com.wang.Leetcode.weekContest.week344;

import java.util.Arrays;
import java.util.Comparator;

public class No6364 {

    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int sum = 0;
        int[] diff = new int[reward1.length];
        for (int i=0;i<reward2.length;i++){
            sum+=reward2[i];
            diff[i] = reward2[i]-reward1[i];
        }
        Arrays.sort(diff);
        for (int i=0;i<k;i++){
            sum-=diff[i];
        }
        String str = "a";
        char a = 'A';
        System.out.println(str.equalsIgnoreCase(String.valueOf(a)));

        return sum;
    }

}
