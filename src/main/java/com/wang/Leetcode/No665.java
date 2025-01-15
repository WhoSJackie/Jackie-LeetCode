package com.wang.Leetcode;

public class No665 {

    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int cnt=0;
        for (int i = 0; i < len-1; i++) {
            // 找到比下一个下标大的值
            if (nums[i]>nums[i+1]){
                if (++cnt>1) return false;
                // 将num[i]变成nums[i+1]
                boolean  flag = false;
                if (i==0 || (nums[i+1]>=nums[i-1])){
                    flag =  true;
                }
                // 变成nums[i+1]nums[i]
                if (i==len-2 || (i<len-2 && nums[i]<=nums[i+2])){
                    flag =  true;
                }
                if (!flag) return false;
            }
        }
        return true;
    }

    public boolean test2(int[] nums){
        int n = nums.length,cnt = 0;
        for (int i = 0; i < n - 1; ++i) {
            int x = nums[i], y = nums[i + 1];
            if (x > y) {
                cnt++;
                if (cnt > 1) {
                    return false;
                }
                if (i > 0 && y < nums[i - 1]) {
                    nums[i + 1] = x;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new No665().checkPossibility(new int[]{1,2,4,5,3}));
    }

}
