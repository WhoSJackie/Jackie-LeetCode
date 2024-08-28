package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No045 {

    // bfs超时
    public int jump1(int[] nums) {
        int len = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        // 从最后一个数开始
        queue.offerLast(len-1);
        int num=1;
        int path=0;
        List<Integer> vis = new ArrayList<>();
        while (!queue.isEmpty()){
            // 计算层次
            if (num<=0){
                num = queue.size();
                path++;
                vis.clear();
            }
            int out = queue.pollFirst();
            //统计有哪些节点能到达out
            for (int i = out-1; i >=0; i--) {
                if (nums[i]>=out-i) {
                    if (i==0) return ++path;
                    if (!vis.contains(i)){
                        queue.offerLast(i);
                        vis.add(i);
                    }
                }
            }
            num--;
        }
        return path;
    }


    // 贪心,从后往前
    public int jump2(int[] nums) {
        int len = nums.length;
        int next=len-1;
        int cnt=0;
        // 从最后一个位置开始，倒着寻找能到达的最远的位置
        while (next!=0){
            for (int i = 0; i <len; i++) {
                if (next-i<=nums[i]){
                    next = i;
                    cnt++;
                    break;
                }
            }
        }
        return cnt;
    }

    // 贪心，从前往后
    public int jump(int[] nums) {
        int len = nums.length;
        int cnt=0;
        int end=0;
        int maxPosition=0;
        for (int i=0;i<len-1;i++){
            // 找到当前能跳的最远范围
            maxPosition = Math.max(maxPosition,i+nums[i]);
            // 到达边界，跳到最远下标,更新边界
            if (i==end){
                end = maxPosition;
                cnt++;
            }
        }
        return cnt;
    }

    public int jump3(int[] nums){
        if(nums==null)return -1;
        if(nums[0]==0||nums.length==1)return 0;
        int i=0,count=0;
        while(i<nums.length)
        {
            if(i+nums[i]>=nums.length-1)return ++count;
            int j=i+1,max=i;
            while(j<nums.length&&j<=i+nums[i])
            {
                if(j+nums[j]>=max+nums[max])
                    max=j;
                j++;
            }
            i=max;
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        System.out.println(new No045().jump(new int[]{2,3,1,1,4}));

    }

}
