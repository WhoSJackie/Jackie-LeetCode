package com.wang.Leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

public class Offer011 {

    public int findMaxLength(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        // 初始化第一个下标
        map.put(0,-1);
        int counter = 0;
        int res = 0;
        for (int i=0;i<nums.length;i++){
            int num = nums[i];
            if (num==1){
                counter++;
            } else{
                counter--;
            }

            if (map.containsKey(counter)){
                int index = map.get(counter);
                res = Math.max(res,index-i);
            } else{
                map.put(counter,i);
            }
        }
        return res;
    }


}
