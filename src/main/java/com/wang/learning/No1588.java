package com.wang.learning;

public class No1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int len=arr.length;
        int i=0;
        int j=len-1;
        int start=len%2==0?len/2:len/2+1;
        int sum=0;
        while(i<=j){
            if(i>j){
                sum+=arr[i]*start+arr[j]*start;
            }
            else{
                sum+=arr[i]*start;
            }
           i++;
           j--;
           start++;
        }
        return sum;

    }




}
