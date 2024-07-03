package com.wang.learning;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No1218 {

    public int longestSubsequence(int[] arr, int difference) {
        //1.复杂版
        int len=arr.length;
//        if(len<3){
//            return 0;
//        }
//        int[] temp=new int[len];
//        //数组初始化为1
//        Arrays.fill(temp,1);
//        Map<Integer,Integer> map=new HashMap<>();
//        map.put(arr[0],temp[0]);
//        for (int i = 1; i < len; i++) {
////            int index=i-1;
////            while(index>=0){
////                if(arr[index]==arr[i]-difference){
////                    temp[i]=Math.max(temp[index]+1,temp[i]);
////                    index--;
////                    continue;
////                }
////                index--;
////            }
//            if(map.containsKey(arr[i]-difference)){
//                temp[i]=map.get(arr[i]-difference)+1;
//            }
//            map.put(arr[i],temp[i]);
//        }
//
//        int max=Integer.MIN_VALUE;
//        for (int i = 0; i < len; i++) {
//            max=Math.max(max,temp[i]);
//        }
//
//        return max;

        //2.空间精简版
        int max=Integer.MIN_VALUE;
        Map<Integer,Integer> temp=new HashMap<>();
        for (int i=0;i<len;i++) {
            temp.put(arr[i],temp.getOrDefault(arr[i]-difference,0)+1);
            max=Math.max(max,temp.get(arr[i]));
        }
        return max;

    }

    public static void main(String[] args){
        int[] nums={4,12,10,0,-2,7,-8,9,-9,-12,-12,8,8};
        int difference=0;
        int res=new No1218().longestSubsequence(nums,difference);
        System.out.println(res);
    }
}
