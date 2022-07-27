package com.wang.Leetcode;

import java.util.*;

public class OfferII115 {

    public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
        int len = nums.length;
        int[] inputDot = new int[len+1];
        Set<Integer>[] graph = new HashSet[len+1];
        // 初始化图
        for (int i=1;i<=len;i++){
            graph[i] = new HashSet<>();
        }
        for (int[] sequence : sequences) {
           int length = sequence.length;
            for (int i = 1; i < length; i++) {
                int pre = sequence[i-1];
                int next = sequence[i];
                graph[pre].add(next);
                // 统计入度
                inputDot[next]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= len; i++) {
            if (inputDot[i]==0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            // 如果此时入度为零的点大于一个，说明组成超序列的有多种可能
            if (queue.size()>1){
                return false;
            }
            Integer poll = queue.poll();
            Set<Integer> set = graph[poll];
            for (Integer index : set) {
                inputDot[index]--;
                if (inputDot[index]==0){
                    queue.offer(index);
                }
            }
        }

        return true;
    }

}
