package com.wang.Leetcode;

public class No055 {
    // 贪心（复杂写法）
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int i=0,j=1,max=i+nums[i],dest=i+nums[i];
        while (i<len&&j<len){
            // 可能一开始就到达终点
            if (max>=len-1) return true;
            // 遍历这个范围内能跳到最远的地方
            while (j<=dest&&j<len){
                if (max < j+nums[j]){
                    max = j+nums[j];
                    if (max>=len-1) return true;
                    i = max;
                }
                j++;
            }
            // 有可能Max没有走到开始能走到的最大位置,仍然需要更新i的位置到原定的dest位置
            i = Math.max(i,j-1);
            // 可能会遇上无法继续往前走的情况，直接返回false
            if (max == dest && i<len-1) return false;
            // 更新下一个范围
            dest = max;
        }
        if (i>=len-1) return true;
        return false;
    }

    // 贪心（简单写法）
    public boolean canJump1(int[] nums) {
        int len = nums.length;
        int max=0;
        for (int i = 0; i < len; ++i) {
            if (i<=max){
                // i能走到max
                max = Math.max(max,i+nums[i]);
                if (max>=len-1) return true;
            } else{
                // i已经超过max，说明i走不到max
                return false;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        System.out.println(new No055().canJump1(new int[]{5,9,3,2,1,0,2,3,3,1,0,0}));
    }



}
