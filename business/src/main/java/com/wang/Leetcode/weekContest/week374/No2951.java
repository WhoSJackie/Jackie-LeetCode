package com.wang.Leetcode.weekContest.week374;

import java.util.ArrayList;
import java.util.List;

public class No2951 {

    public List<Integer> findPeaks(int[] mountain) {
        int l=0;
        int m = 1;
        int r = 2;
        int len = mountain.length;
        List<Integer> res = new ArrayList<>();
        if (len<3) return res;
        while (r<len){
            if ((mountain[m]>mountain[l])&&(mountain[m]>mountain[r])){
                res.add(m);
            }
            l++;
            m++;
            r++;
        }
        return res;
    }

}
