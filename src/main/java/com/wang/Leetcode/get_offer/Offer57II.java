package com.wang.Leetcode.get_offer;

import java.util.ArrayList;
import java.util.List;

public class Offer57II {

    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1;
        int r = 1;
        int sum=0;
        while (l<=target/2){
            if (sum<target){
                sum+=r;
                r++;
            } else if(sum>target){
                sum-=l;
                l++;
            } else{
                int[] arr = new int[r-l+1];
                for (int i=l;i<=r;i++){
                    arr[i-l] = i;
                }
                l++;
                r++;
                res.add(arr);
            }
        }
        int[][] re = new int[res.size()][];
        for (int i=0;i<res.size();i++) {
            re[i] = res.get(i);
        }
        return re;
    }

}
