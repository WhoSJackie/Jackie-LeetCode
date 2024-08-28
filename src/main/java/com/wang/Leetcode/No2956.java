package com.wang.Leetcode;

public class No2956 {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        // 找到两个数组的最大值,并且创建数组
        int max1 =Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int res1 = 0;
        int res2 = 0;
        for (int i : nums1) {
            if (i>max1) max1 = i;
        }
        for (int i : nums2) {
            if (i>max2) max2 = i;
        }
        int[] arr1 =  new int[max1+1];
        int[] arr2 = new int[max2+1];
        // 统计元素数量
        for (int i : nums1) {
            arr1[i]++;
        }
        for (int i : nums2) {
            arr2[i]++;
        }
        for (int i = 0; i < arr2.length; i++) {
            if (i<=max1 && arr2[i]>0) res1+=arr1[i];
        }
        for (int i = 0; i < arr1.length; i++) {
            if (i<=max2 && arr1[i]>0) res2+=arr2[i];
        }
        return new int[]{res1,res2};
    }

    public static void main(String[] args) {
       int[] res =  new No2956().findIntersectionValues(new int[]{4,3,2,3,1},new int[]{2,2,5,3,2,6});
        for (int i : res) {
            System.out.println(i);
        }
    }
}
