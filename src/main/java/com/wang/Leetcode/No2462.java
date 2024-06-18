package com.wang.Leetcode;

import java.util.PriorityQueue;

public class No2462 {

    // 法一 使用暴力解法 超时
    public long totalCost1(int[] costs,int k,int candidates){
        int num=costs.length;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int res=0;
        int cnt = 0;
        int index = 0;
        for (int i = 0; i < k; i++) {
            min = Integer.MAX_VALUE;
            minIndex = 0;
            // 前后分出两组
            if (2*candidates<=num){
                cnt = 0;
                index = 0;
                // 先找到左边最小
                while (cnt<candidates){
                    if (costs[index]!=-1){
                        if (min>costs[index]){
                            minIndex = index;
                            min = costs[index];
                        }
                        cnt++;
                    }
                    index++;
                }
                // 在从右边找到最小
                cnt=0;
                index=costs.length-1;
                while (cnt<candidates){
                    if (costs[index]!=-1){
                        if (min>costs[index]){
                            minIndex = index;
                            min = costs[index];
                        }
                        cnt++;
                    }
                    index--;
                }
                res+=costs[minIndex];
                costs[minIndex] = -1;
            } else{
                // 在总的里面找最小
                for (int j = costs.length-1; j >=0; j--) {
                    if (costs[j]!=-1){
                        if (costs[j]<min){
                            min = costs[j];
                            minIndex=j;
                        }
                    }
                }
                res+=costs[minIndex];
                costs[minIndex] = -1;
            }
            num--;
        }
        return res;
    }

    // 法二 使用小根堆
    public long totalCost(int[] costs,int k,int candidates){
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b)->a[0]!=b[0]?a[0]-b[0]:a[1]-b[1]);
        int len = costs.length;
        // 初始化左右当前边界
        int left = candidates-1;
        int right = len-candidates;
        boolean flag = true;
        long res=0;
        for (int i = 0; i < k; i++) {
            // 当左右集合没有交集时，两边分开遍历
            if (left+1<right){
                // 如果是第一次，那么需要依次添加左右集合的元素
                if (flag){
                    // 添加左边
                    for (int l = 0; l <= left; l++) {
                        queue.offer(new int[]{costs[l],l});
                    }
                    //添加右边
                    for (int r = len-1; r >= right; r--) {
                        queue.offer(new int[]{costs[r],r});
                    }
                    flag = false;
                }
                int[] first = queue.poll();
                res+=first[0];
                // 如果在左边
                if (first[1]<=left){
                    left++;
                    queue.offer(new int[]{costs[left],left});
                } else{
                    // 属于右边
                    right--;
                    queue.offer(new int[]{costs[right],right});
                }
            } else{
                if (queue.size()>0) {
                    res+=queue.poll()[0];
                } else{
                    if (flag){
                        for (int a = 0; a < len; a++) {
                            queue.offer(new int[]{costs[a],a});
                        }
                        flag = false;
                        res+=queue.poll()[0];
                    }
                }
            }
        }
        return res;
    }

    // 官方题解
    public long totalCost2(int[] costs, int k, int candidates) {
        int n = costs.length;
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        int left = candidates - 1, right = n - candidates;
        if (left + 1 < right) {
            for (int i = 0; i <= left; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
            for (int i = right; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        } else {
            for (int i = 0; i < n; ++i) {
                pq.offer(new int[]{costs[i], i});
            }
        }
        long ans = 0;
        for (int i = 0; i < k; ++i) {
            int[] arr = pq.poll();
            int cost = arr[0], id = arr[1];
            ans += cost;
            if (left + 1 < right) {
                if (id <= left) {
                    ++left;
                    pq.offer(new int[]{costs[left], left});
                } else {
                    --right;
                    pq.offer(new int[]{costs[right], right});
                }
            }
        }
        return ans;
    }



    public static void main(String[] args) {
        System.out.println(new No2462().totalCost(new int[]{28,35,21,13,21,72,35,52,74,92,25,65,77,1,73,32,43,68,8,100,84,80,14,88,42,53,98,69,64,40,60,23,99,83,5,21,76,34}, 32, 12));
    }

}
