package com.wang.learning;

public class Offer069 {
    public int peakIndexInMountainArray(int[] arr) {
        //o(n)的方法
//        int max=arr[0];
//        int index=0;
//        int len=arr.length;
//        for (int i = 1; i < len; i++) {
//            if(arr[i]>=max){
//                max=arr[i];
//                index=i;
//            }
//        }
//        return index;

        //o(logn)方法

        int left=0;
        int right=arr.length-2;
        while(left<right){
         int mid=left+(right-left)/2;
         if(arr[mid]<arr[mid+1]){
             left=mid+1;
         }
         else{
             right=mid;
         }
        }

        return right;
    }
}
