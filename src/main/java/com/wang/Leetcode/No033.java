package com.wang.Leetcode;

public class No033 {
    // 一次二分
    public int search(int[] nums, int target) {
        int len = nums.length;
        int l = 0,r = len-1;
        // if (l==r) return nums[l]==target?l:-1;
        while (l<=r){
            int mid = l+(r-l)/2;
            int t = target-(nums[len-1]);
            int m = nums[mid]-(nums[len-1]);
            if (t==0) return t;
            // 判断target在mid左边还是右边
            if (t*m<0){
                // 分布在两个区间
               if (t<m) l++;
               else r--;
            }  else{
                //分布在一个区间
                if (t==m) return mid;
                else if (t>m) l++;
                else r--;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new No033().search(new int[]{3,1}, 1));
    }

}
