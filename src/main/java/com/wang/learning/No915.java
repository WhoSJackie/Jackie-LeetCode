package com.wang.learning;

public class No915 {

    public int partitionDisjoint(int[] nums) {
        // 初始化指针
        int l=0;
        int[] minArr = new int[nums.length];
        int[] maxArr = new int[nums.length];
        int len = nums.length;
        minArr[len-1] = nums[len-1];
        for (int i = len-2; i >=0; i--) {
            minArr[i] = Math.min(nums[i], minArr[i + 1]);
        }
        maxArr[0] = nums[0];
        for (int j=1;j<len;j++){
            maxArr[j] = Math.max(nums[j],maxArr[j-1]);
        }
        while(l<nums.length-2){
            if (maxArr[l]<=minArr[l+1]){
                break;
            }
            l++;
        }
        return l+1;
    }

    public static void main(String[] args) {
        System.out.println(new No915().partitionDisjoint(new int[]{1,1,1,0,6,2}));
    }

}
