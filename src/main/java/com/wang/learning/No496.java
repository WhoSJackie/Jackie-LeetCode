package com.wang.learning;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class No496 {

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<int[]> stack = new ArrayDeque<>();
        Map<Integer,Integer> store =  new HashMap<>();
        stack.push(new int[]{0,nums2[0]});
        store.put(nums2[0],-1);
        int i=1;
        while (i < nums2.length) {
            if (nums2[i]<=stack.peek()[1]){
                stack.push(new int[]{i,nums2[i]});
                store.put(nums2[i],-1);
                i++;
            } else{
                while(stack.size()>0&&stack.peek()[1]<=nums2[i]){
                    store.put(stack.pop()[1],nums2[i]);
                }
                stack.push(new int[]{i,nums2[i]});
            }
        }
        int[] res = new int[nums1.length];
        for (int j = 0; j < nums1.length; j++) {
            res[j] = store.get(nums1[j]);
        }

        return res;
    }

    public static void main(String[] args) {
        int[] res = new No496().nextGreaterElement(new int[]{1,3,5,2,4}, new int[]{5,4,3,2,1});
        System.out.println(res);
    }
}
