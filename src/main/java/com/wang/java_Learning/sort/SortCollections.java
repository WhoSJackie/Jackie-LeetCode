package com.wang.java_Learning.sort;

public class SortCollections {



    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,1,5,7};
        SortParent sortParent1 = new InsertSort();
        SortParent sortParent2 = new BubbleSort();
        sortParent2.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }


}
