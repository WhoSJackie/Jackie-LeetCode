package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class No2451 {

    public String oddString(String[] words) {
        int len = words.length;
        if (Arrays.equals(getDiffStr(words[0]),getDiffStr(words[1]))){
            for (int i=2;i<len;i++){
                if (!Arrays.equals(getDiffStr(words[0]),getDiffStr(words[i]))) return words[i];
            }
        }
        return Arrays.equals(getDiffStr(words[0]),getDiffStr(words[2]))?words[1]:words[0];
    }

    private int[] getDiffStr(String str){
        int[] arr = new int[str.length()];
        char[] temps = str.toCharArray();
        int index=0;
        for (int j=1;j<temps.length;j++){
            arr[index++] = ((temps[j]-'a')-(temps[j-1]-'a'));
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(new No2451().oddString(new String[]{"abm","bcn","alm"}));
    }


}
