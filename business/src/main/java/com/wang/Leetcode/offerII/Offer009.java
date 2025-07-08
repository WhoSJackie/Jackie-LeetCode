package com.wang.Leetcode.offerII;

public class Offer009 {

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // 法一 o(n^2)
//        int len = nums.length;
//        int l=0;
//        int r = 0;
//        int sum=0;
//        int cnt=0;
//        for (int i=0;i<len;i++){
//            l = i;
//            r = i;
//            sum=nums[l];
//            while (sum<k){
//                cnt++;
//                r++;
//                if (r>=len) break;
//                sum*=nums[r];
//            }
//        }
//        return cnt;

        // 同向双指针
        int len = nums.length;
        int cnt = 0;
        int sum = 1;
        int l = 0;
        for (int r=0;r<len;r++){
            sum*=nums[r];
            while (sum>=k){
                sum/=nums[l++];
            }
            cnt+=r-l+1;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Offer009().numSubarrayProductLessThanK(new int[]{10, 5, 2, 6}, 100));
    }

}
