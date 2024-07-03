package com.wang.learning;

public class No704 {
    public int search(int[] nums, int target) {
        int len=nums.length;
        int i=0;
        int j=len-1;
        int mid=i+(j-i)/2;
        while(i<=j){
            mid=i+(j-i)/2;
            if(nums[mid]==target){
                return mid;
            }
            else if(nums[mid]<target){
                i=mid+1;
            }
            else{
                j=mid-1;
            }
        }

        return -1;
    }
}
