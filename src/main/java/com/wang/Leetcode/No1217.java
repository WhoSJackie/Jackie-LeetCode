package com.wang.Leetcode;

import java.util.HashMap;
import java.util.Map;

public class No1217 {
    public int minCostToMoveChips(int[] position) {
        int odd = 0;
        int even = 0;
        // 找到是偶数位置砝码多还是奇数位置砝码多
        for (int i = 0; i < position.length; i++) {
            if (position[i]%2==0){
                even++;
            } else{
                odd++;
            }
        }

        // 计算cost
        return Math.min(even,odd);

    }

    public static void main(String[] args) {
        System.out.println(new No1217().minCostToMoveChips(new int[]{1, 2, 3}));
    }
}
