package com.wang.Leetcode.weekContest.week325;

public class No2516 {

    public int takeCharacters(String s, int k) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        // 统计a,b,c的数量
        int[] cnt = new int[3];
        for (int i = 0; i < len; i++) {
            cnt[ch[i]-'a']++;
        }

        // 特殊情况讨论
        if (cnt[0]<k||cnt[1]<k||cnt[2]<k){
            return -1;
        }

        if (cnt[0]==k&&cnt[1]==k&&cnt[2]==k){
            return len;
        }

        int l = 0,r = 0;
        int[] curCnt = new int[3];
        int max = Integer.MIN_VALUE;
        // 开始滑动窗口，找到最长的满足条件的窗口
        while (l<len){
            if (r<len){
                curCnt[ch[r++]-'a']++;
            }

            // 如果窗口的字符太多，不满足条件，那么需要移动left
            while ((curCnt[0]>cnt[0]-k||curCnt[1]>cnt[1]-k||curCnt[2]>cnt[2]-k)&&(l<len)){
                curCnt[ch[l++]-'a']--;
            }

            // 统计一次结果
            max = Math.max(max,r-l);
            if (r>=len){
                break;
            }
        }
        return len-max;
    }

}
