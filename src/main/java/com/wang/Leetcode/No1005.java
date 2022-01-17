package com.wang.Leetcode;

public class No1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {

        //对数组从小到大排序
        quickSort(nums,0,nums.length-1);
        int min=Integer.MAX_VALUE;
        int max_index=0;
        int count=k;
        for (int i = 0; i < nums.length; i++) {
            if(Math.abs(nums[i])<min){
                min=Math.abs(nums[i]);
                max_index=i;
            }
            if(count>0){
                if(nums[i]<=0){
                    nums[i]=-nums[i];
                    count--;
                }
            }

        }
        if(count!=0){
            if(count%2!=0){
                nums[max_index]=-nums[max_index];
            }
        }

        int sum=0;
        for (int i : nums) {
            sum+=i;
        }
        return sum;

    }

    public void quickSort(int[] nums,int s,int e){
        if(s>=e){
            return;
        }
        int i=s;
        int j=e;
        int index=nums[s];
        while(i<j){
            while(i<j&&nums[j]>index) {
                j--;
            }

            while(i<j&&nums[i]<=index){
                i++;
            }
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
        }

        nums[s]=nums[i];
        nums[i]=index;

        quickSort(nums,i+1,e);
        quickSort(nums,s,i-1);
    }

    public static void main(String[] args) {
        int[] nums={3,-1,0,2};
        No1005 n=new No1005();
        n.quickSort(nums,0,nums.length-1);
        for (int num : nums) {
            System.out.print(num+",");
        }

        int i = n.largestSumAfterKNegations(nums, 3);
        System.out.println();
        System.out.println(i);
    }


}
