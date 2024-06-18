package com.wang.Leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class No857 {
    // 贪心+大根堆
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        Integer[] h = new Integer[n];
        for (int i = 0; i < n; i++) {
            h[i] = i;
        }
        Arrays.sort(h, (a, b) -> {
            return quality[b] * wage[a] - quality[a] * wage[b];
        });
        double res = 1e9;
        double totalq = 0.0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);
        for (int i = 0; i < k - 1; i++) {
            totalq += quality[h[i]];
            pq.offer(quality[h[i]]);
        }
        for (int i = k - 1; i < n; i++) {
            int idx = h[i];
            totalq += quality[idx];
            pq.offer(quality[idx]);
            double totalc = ((double) wage[idx] / quality[idx]) * totalq;
            res = Math.min(res, totalc);
            totalq -= pq.poll();
        }
        return res;
    }


    public double mincostToHireWorkers1(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Integer[] ix = new Integer[len];
        int totalq = 0;
        double totalc = 0.0;
        double res = Double.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            ix[i] = i;
        }

        // 按照wage[i]/quality[i]对下标数组排序
        Arrays.sort(ix, (a,b)->{
            return wage[a]*quality[b]-wage[b]*quality[a];
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b)->b-a);
        // 往queue中初始化权重最小的k-1个元素,队列按照质量加入元素
        for (int i = 0; i < k - 1; i++) {
            totalq+=quality[ix[i]];
            queue.offer(quality[ix[i]]);
        }

        // 权重矩阵k-1到len的范围内不断加入第K个元素，该权重大于前k-1个元素，刷新最小结果
        for (int i = k-1; i < len; i++) {
            int idx = ix[i];
            totalq+=quality[idx];
            queue.offer(quality[idx]);
            totalc = (1.0*wage[idx]/quality[idx])*totalq;
            if (totalc<res) res = totalc;
            totalq-=queue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] quality = new int[]{3,1,10,10,1};
        int[] wage = new int[]{4,8,2,2,7};
        int k= 3;
        System.out.println(new No857().mincostToHireWorkers1(quality,wage,k));
    }


}
