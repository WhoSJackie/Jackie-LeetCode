package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.List;

public class No118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res= new ArrayList<>();
        for (int i=0;i<numRows;i++){
            List<Integer> rowRes = new ArrayList<>();
            for (int j=0;j<=i;j++){
                if (j==0 || j==i) rowRes.add(1);
                else {
                    rowRes.add(res.get(i-1).get(j-1)+res.get(i-1).get(j));
                }
            }
            res.add(new ArrayList<>(rowRes));
        }
        return res;
    }

    public static void main(String[] args) {
        new No118().generate(5);
    }
}
