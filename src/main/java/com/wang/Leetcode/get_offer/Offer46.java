package com.wang.Leetcode.get_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Offer46 {

    public int translateNum(int num) {
        if (num==0) return 1;
        // 拆成数组
        int n = 0;
        List<Integer> list = new ArrayList<>();
        while (num!=0){
            n = num%10;
            num = num/10;
            list.add(n);
        }
        Collections.reverse(list);
        int[] dp = new int[list.size()];
        dp[0] = 1;
        int nu = (list.get(0)*10+list.get(1));
        if (nu>=0&&nu<=25) {
            dp[1] = 2;
        } else{
            dp[1] = 1;
        }
        for (int i=2;i<list.size();i++) {
            nu = (list.get(i-1)*10+list.get(i));
            if (nu>=0&&nu<=25) {
                dp[i] = dp[i-1]+dp[i-2];
            } else{
                dp[i] = dp[i-1];
            }
        }

        return dp[list.size()-1];

    }

}
