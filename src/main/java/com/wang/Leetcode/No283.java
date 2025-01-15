package com.wang.Leetcode;

public class No283 {

    public void moveZeroes(int[] nums) {
        int len = nums.length;
        // 当前0应该移动到的位置
        int tmp = len-1;
        for (int i=len-1;i>=0;i--){
            if (nums[i]==0){
                if (i!=tmp){
                    int j =i;
                    while (j<tmp){
                        int temp = nums[j+1];
                        nums[j+1] = nums[j];
                        nums[j] = temp;
                        j++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0,1,0,3,12};
        new No283().moveZeroes(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

}
