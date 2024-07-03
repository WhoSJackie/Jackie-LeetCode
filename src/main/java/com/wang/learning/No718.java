package com.wang.learning;

public class No718 {
    public int findLength(int[] nums1, int[] nums2) {
       int len1=nums1.length;
       int len2=nums2.length;
       int[][] res=new int[len1+1][len2+1];
       int max=0;
        for (int i = 1; i <= len1; i++) {
            int temp=nums1[i-1];
            for (int j = 1; j <= len2; j++) {
                if(nums2[j-1]==temp){
                    res[i][j]=res[i-1][j-1]+1;
                    max=Math.max(res[i][j],max);
                }
            }
        }
        return max;

    }
}
