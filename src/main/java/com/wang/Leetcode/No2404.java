package com.wang.Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No2404 {


//    public int mostFrequentEven(int[] nums) {
//        Map<Integer,Integer> map = new HashMap<>();
//        for (int num :nums){
//            if ((num&1)==0){
//                map.put(num,map.getOrDefault(num,0)+1);
//            }
//        }
//
//        if (map.size()==0) return -1;
//
//        // 筛选map中偶数数量
//        int max=0;
//        int num=0;
//        for (Map.Entry entry: map.entrySet()){
//            int temp = (int)entry.getValue();
//            int tmpNum = (int)entry.getKey();
//            if (temp>max){
//                max = temp;
//                num = (int)entry.getKey();
//            }
//            if (temp==max&&tmpNum<num){
//                max = temp;
//                num = tmpNum;
//            }
//        }
//
//        return num;
//
//    }

    public int mostFrequentEven(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        int cnt = 0;
        int res = -1;
        int i=0;
        int j=0;

        while (i<=j&&j<len){
            while ((nums[i]&1)==1){
                i++;
            }
            j=i;
            while (j<len&&nums[i]==nums[j]) {
                j++;
            }

            if ((j-i)>cnt||((j-i)==cnt&&res<nums[i])){
                cnt = (j-i);
                res = nums[i];
            }
            i = j;
        }

        return res;
    }


}
