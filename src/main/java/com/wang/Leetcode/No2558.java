package com.wang.Leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class No2558 {
    // 1.法一 原地排序
//    public long pickGifts(int[] gifts, int k) {
//        // 第一次排序
//        Arrays.sort(gifts);
//        // 开始挑选礼物，并且重新排序
//        for (int i=0;i<k;i++){
//            // 每次取最后一个
//            double temp = gifts[gifts.length-1];
//            temp = Math.floor(Math.sqrt(temp));
//            int index=gifts.length-2;
//            // 重新交换找到位置
//            while (index>=0&&temp<gifts[index]){
//                gifts[index+1] = gifts[index];
//                index--;
//            }
//            gifts[index+1] = (int)temp;
//        }
//        // 计算剩余的礼物
//        long sum=0;
//        for (int gift : gifts) {
//            sum+=gift;
//        }
//        return sum;
//    }

    // 2.最大堆
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2-o1);
        // 建立初始堆
        for (int gift : gifts) {
            queue.offer(gift);
        }
        // 进行k次操作
        while (k>0){
            k--;
            int temp = queue.poll();
            queue.offer((int)Math.floor(Math.sqrt(temp)));
        }
        // 结果统计
        long res = 0;
        while (!queue.isEmpty()) {
            res+=queue.poll();
        }
        return res;
    }


}
