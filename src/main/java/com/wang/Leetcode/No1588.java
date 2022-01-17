package com.wang.Leetcode;

public class No1588 {
    public int sumOddLengthSubarrays(int[] arr) {
        int len=arr.length;
        int count=0;
        int i;
            for (int j = 1; j <= len; j+=2) {
                i=0;
                while(i<len){
                    if(i+j<=len){
                        count+=sum(i,i+j,arr);
                    }
                i=i+1;
            }
        }
        return count;
    }

    public int sum(int i,int j,int[] arr){
        int len=j-i;
        int count=0;
        for (int i1 = i; i1 < j; i1++) {
            count+=arr[i1];
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a={1,4,2,5,3};
        No1588 n=new No1588();
        System.out.println(n.sumOddLengthSubarrays(a));
    }
}
