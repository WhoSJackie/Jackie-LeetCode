package com.wang.learning;

import java.util.*;

public class No229 {

    public List<Integer> majorityElement(int[] nums) {
        //1.使用hashmap进行计数
        int len=nums.length;
        List<Integer> res=new ArrayList<>();
//        Map<Integer,Integer> map=new HashMap<>();
//        for (int i = 0; i < len; i++) {
//            if(map.containsKey(nums[i])){
//                map.put(nums[i],map.get(nums[i])+1);
//            }
//            else{
//                map.put(nums[i],1);
//            }
//        }
//
//        int threshold=len/3;
//        for (Integer integer : map.keySet()) {
//            if(map.get(integer)>threshold){
//                res.add(integer);
//            }
//        }
//
//        return res;

        int temp=nums[0];
        if(len<=2){
            res.add(nums[0]);
            for (int i = 1; i < len; i++) {
                if(nums[i]!=temp){
                    res.add(nums[i]);
                }
            }
            return res;
        }
        //2.先排序再进行统计
        Arrays.sort(nums);
        int i=1;
        //统计当前计数对象的个数
        int index=1;
        while(i<len){
            //如果当前下标和上一个下标的数值相等，
            //则将计数器index++，然后判断是否大于len/3.
            if(nums[i]==nums[i-1]){
                index++;
                if(index>len/3){
                        res.add(nums[i]);
                        //如果判断为众数，则没必要继续计数
                        while(i<len&&nums[i]==nums[i-1]){
                            i++;
                        }
                        continue;
                }
            }

            //否则，则将计数位重新校准，重新计数
            else{
                index=1;
            }
            i++;
        }

        return res;
    }


    public static void main(String[] args) {
        int[] nums={1};
        List<Integer> res=new No229().majorityElement(nums);
        for (Integer re : res) {
            System.out.println(re);
        }
    }
}
