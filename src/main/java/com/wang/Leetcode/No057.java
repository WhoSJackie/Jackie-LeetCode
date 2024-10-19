package com.wang.Leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No057 {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        Deque<int[]> res = new LinkedList<>();
        int len = intervals.length;
        if (len==0){
            return new int[][]{{newInterval[0],newInterval[1]}};
        }
        int index=-1;
        for (int i = len-1; i >=0; i--) {
            // 找到起始位置
            if (newInterval[1]>=intervals[i][1]){
                index=i;
                break;
            } else{
                res.push(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        int ixS = newInterval[0],ixE = newInterval[1];
        // 设定起始开始，结束点
        if (index==len-1){
            if (newInterval[0]<=intervals[index][1]){
                ixS = Math.min(newInterval[0],intervals[index][0]);
                ixE = Math.max(newInterval[1],intervals[index][1]);
                index--;
            }
        } else if (index!=-1 && (intervals[index][1]==newInterval[1])){
            ixS = Math.min(newInterval[0],intervals[index][0]);
            ixE = newInterval[1];
            index--;
        } else{
            if (newInterval[1]>=intervals[index+1][0]){
                if (!res.isEmpty()){
                    res.poll();
                }
                ixS = Math.min(newInterval[0],intervals[index+1][0]);
                ixE = intervals[index+1][1]  ;
            }
        }
        int tmp = index;
        while(tmp>=0){
            int curS = intervals[tmp][0];
            int curE = intervals[tmp][1];
            if (curE>=ixS){
                if (curS<ixS){
                    ixS = curS;
                }
            } else{
                res.push(new int[]{ixS,ixE});
                ixS = curS;
                ixE = curE;
            }
            tmp--;
        }
        // 处理最后一个区间
        if (res.isEmpty() || res.peek()[0]!=ixS) res.push(new int[]{ixS,ixE});

        int[][] r = new int[res.size()][2];
        int size = res.size();
        for (int i = 0; i < size; i++) {
            int[] temp = res.poll();
            r[i][0] = temp[0];
            r[i][1] = temp[1];
        }
        return r;
    }

    public static void main(String[] args) {
        // int[][] insert = new No057().insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16}}, new int[]{4,8});
        int[][] insert = new No057().insert(new int[][]{{1,7},{9,17},{18,20}}, new int[]{4,7});
        for (int[] ints : insert) {
            System.out.println(ints[0]+"-"+ints[1]);
        }
    }


}
