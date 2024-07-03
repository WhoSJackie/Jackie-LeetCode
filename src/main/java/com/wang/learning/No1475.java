package com.wang.learning;

public class No1475 {

    public int[] finalPrices(int[] prices) {
        int[] res = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            int temp = prices[i];
            boolean flag = false;
            for (int j=i+1;j<prices.length;j++){
                if (prices[j]<=temp){
                    res[i] = temp-prices[j];
                    flag = true;
                    break;
                }
            }
            if (!flag){
                res[i] = temp;
            }
        }
        return res;
    }
}
