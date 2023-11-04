package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No2465 {

    public int distinctAverages(int[] nums) {
        List<Double> res = new ArrayList<>();
        Arrays.sort(nums);
        int i=0;
        int j =nums.length-1;
        while (i<j){
            double temp = (i+j)/2.0;
            if (!res.contains(temp)){
                res.add(temp);
            }
            i++;
            j--;
        }
        return res.size();
    }

    public static void main(String[] args) {
        int res = new No2465().distinctAverages(new int[]{4,1,4,0,3,5});
        System.out.println(res);
    }

}
