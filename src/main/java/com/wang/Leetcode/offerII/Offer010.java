package com.wang.Leetcode.offerII;

import java.util.HashMap;
import java.util.Map;

public class Offer010 {

    public int subarraySum(int[] nums, int k) {
        // 法一 正常遍历 o(n^2)
//        int len = nums.length;
//        int sum=0;
//        int cnt=0;
//        for (int i=0;i<len;i++){
//            sum=0;
//            for (int j=i;j<len;j++){
//                sum+=nums[j];
//                if (sum==k) cnt++;
//            }
//        }
//        return cnt;


        //法二 hash+前缀和
        int res = 0;
        int len = nums.length;
        if (len==0) return res;
        int[] sums = new int[len+2];
        // 计算前缀和
        sums[0] = nums[0];
        for (int i = 1; i < len; i++) {
            sums[i]=sums[i-1]+nums[i];
        }

        // 创建hashmap
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        for (int i=0;i<len;i++){
            int tmp = sums[i]-k;
            res+=map.getOrDefault(tmp,0);
            map.put(sums[i],map.getOrDefault(sums[i],0)+1);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Offer010().subarraySum(new int[]{1}, 1));
    }

}
