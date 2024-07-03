package com.wang.learning;

import java.util.ArrayDeque;
import java.util.Deque;

public class StockSpanner {
//    List<Integer> stock;
//
//    public StockSpanner() {
//        stock = new ArrayList<>();
//    }
//
//    public int next(int price) {
//        int count=0;
//        // 统计小于或等于今天股票价格的连续天数
//        stock.add(price);
//        for (int i = stock.size()-1; i >=0; i--) {
//            if (stock.get(i)<=price){
//                count++;
//            } else{
//                break;
//            }
//        }
//        return count;
//    }

    Deque<int[]> queue;
    int idx;
    public StockSpanner(){
        queue = new ArrayDeque<>();
        queue.push(new int[]{-1,Integer.MAX_VALUE});
        idx = -1;
    }

    public int next(int price){
        idx++;
        while (price>=queue.peek()[1]){
            queue.pop();
        }

        int res = idx-queue.peek()[0];
        queue.push(new int[]{idx,price});
        return res;
    }

    public static void main(String[] args) {

    }

}
