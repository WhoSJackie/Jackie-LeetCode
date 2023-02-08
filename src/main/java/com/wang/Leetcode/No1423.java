package com.wang.Leetcode;

public class No1423 {

    public int maxScore(int[] cardPoints, int k) {
        int len = cardPoints.length;
        int cnt = 0;
        // 统计点数总和
        for (int cardPoint : cardPoints) {
            cnt+=cardPoint;
        }

        int l = 0,r = 0;
        int curCnt=0;
        int min = Integer.MAX_VALUE;
        // 滑动窗口维护一个len-k大小的窗口，找到最小点数
        while (r<len){
            if (r<len){
                curCnt+=cardPoints[r++];
            }

            while ((r-l)>(len-k)&&l<len){
                curCnt-=cardPoints[l++];
            }
            if (r-l==(len-k)){
                min = Math.min(min,curCnt);
            }
        }
        return cnt-min;
    }

}
