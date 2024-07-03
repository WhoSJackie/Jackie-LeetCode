package com.wang.learning;

public class No31 {

    public void nextPermutation(int[] nums) {
        int tempMax = -1;
        int tempMin = -1;
        int len = nums.length;
        for (int i = len-1; i >0; i--) {
            if (nums[i-1]<nums[i]){
                tempMax = i;
                tempMin = i-1;
                break;
            }
        }
        // 如果找到了第一个相邻升序的数字,
        if (tempMax!=-1){
            for (int j=len-1;j>=tempMax;j--){
                if (nums[j]>nums[tempMin]){
                    // 找到第一个比tempMin大的数，则交换两个数
                    int temp = nums[tempMin];
                    nums[tempMin] = nums[j];
                    nums[j] = temp;
                    break;
                }
            }
        }
        // 如果没找到第一个相邻升序的数字，说明整个数字都是逆序
        if (tempMax==-1){
            tempMax = 0;
        }
        // 将tempMax之后的数字调整为升序，这样保证最小
        for (int z = tempMax;z<(tempMax+(len-tempMax)/2);z++){
            int rev = nums[z];
            nums[z] = nums[len+tempMax-1-z];
            nums[len+tempMax-1-z] = rev;
        }

    }

    public static void main(String[] args) {
        int[] a = {1,3,2};
        new No31().nextPermutation(a);
        for (int i : a) {
            System.out.println(i);
        }
    }



}
