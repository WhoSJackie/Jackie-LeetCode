package com.wang.Leetcode;

public class No413 {
    public int numberOfArithmeticSlices(int[] nums) {
        int len=nums.length;
        if(len<3){
            return 0;
        }
        int d=nums[0]-nums[1];
        int t=0;
        int sum=0;
        for (int i = 2; i < len; i++) {
            int temp=nums[i-1]-nums[i];
            if(temp==d){
                t++;
            }
            else{
                d=temp;
                t=0;
            }
            sum+=t;
        }

        return sum;
    }

    public int numberOfArithmeticSlices2(int[] nums){
        int len=nums.length;
        if(len<3){
            return 0;
        }
        int sum=0;
        for (int i = 0; i < len-1;) {
            int j=i;
            int diff=nums[i]-nums[i+1];
            while(j+1<len&&nums[j]-nums[j+1]==diff) j++;
            int start=1;
            int end=j-i-1;
            sum+=(start+end)*(j-i-1)/2;
            i=j;
        }
        return sum;

    }
}
