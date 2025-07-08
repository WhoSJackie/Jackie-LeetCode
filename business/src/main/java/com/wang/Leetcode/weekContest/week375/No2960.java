package com.wang.Leetcode.weekContest.week375;

public class No2960 {

    public int countTestedDevices(int[] batteryPercentages) {
        int powerMinus = 0;
        int cnt=0;
        int len = batteryPercentages.length;
        for (int i = 0; i < batteryPercentages.length; i++) {
            if (batteryPercentages[i]-powerMinus>0){
                powerMinus++;
                cnt++;
            }
        }
        return cnt;
    }

}
