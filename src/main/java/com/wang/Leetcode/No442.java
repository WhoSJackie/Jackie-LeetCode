package com.wang.Leetcode;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class No442 {
    List<Integer> findDuplicates(int[] nums){
        int n = nums.length;
        int[] arr = new int[n+1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr[nums[i]]++;
        }
        // 统计出现两次的整数
        for (int i = 1; i < arr.length; i++) {
            if (arr[i]==2) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        LocalDate localDate = LocalDate.now();
        System.out.println(Integer.valueOf(localDate.toString().replace("-","")));
    }
}
