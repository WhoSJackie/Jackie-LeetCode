package com.wang.java_Learning.sort;

public class SortCollections implements SortParent{

    @Override
    public void sort(int[] nums) {

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,4,3,1,5,7};
        SortParent insertSort = new InsertSort();
        SortParent bubbleSort = new BubbleSort();
        SortParent quickSort = new QuickSort();
        quickSort.sort(nums);
        for (int num : nums) {
            System.out.println(num);
        }

    }



}
