package com.wang.learning;

public class No1668 {

    public int maxRepeating(String sequence, String word) {
        int len = sequence.length();
        int len1 = word.length();
        int count=0;
        int[] arr = new int[len+1];

        for (int i = 1; i <= len; i++) {
            if (i-len1<0) continue;
            if (sequence.substring(i-len1,i).equals(word)){
                arr[i] = arr[i-len1]+1;
            }
            count = Math.max(count,arr[i]);
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new No1668().maxRepeating("aaabaaaabaaabaaaabaaaabaaaabaaaaba", "aaaba"));
    }

}
