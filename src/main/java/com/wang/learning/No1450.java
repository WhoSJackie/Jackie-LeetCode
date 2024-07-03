package com.wang.learning;

public class No1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < endTime.length; i++) {
            if (endTime[i]>=queryTime&&startTime[i]<=queryTime){
                res++;
            }
        }
        return res;
    }
}
