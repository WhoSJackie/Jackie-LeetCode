package com.wang.learning;

import java.util.ArrayList;
import java.util.Collections;

public class SortSeries {

    //计数排序
    public static int[] CountSort(int[] nums){
        int max=nums[0];
        int min=nums[0];
        //1.找到最大值
        for(int i=1;i<nums.length;i++){
            if(nums[i]>=max){
                max=nums[i];
            }
            if(nums[i]<min){
                min=nums[i];
            }
        }
        //2.创建一个max+1长度的数组，该数组index为需要排序数组的元素，
        //下标对应的值为元素的个数
        int[] arr=new int[max-min+1];

        //3.进行遍历收集元素
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]-min]++;
        }

        //4.创建结果数组,依次处理arr数组，并且将排序结果放入结果数组
        int[] res=new int[nums.length];
        int index=0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]!=0){
                while(arr[i]>0){
                    res[index++]=i+min;
                    arr[i]--;
                }
            }
        }

        return res;

    }


    //桶排序
    public static int[] buckSort(int[] nums1){
        int max=nums1[0];
        int min=nums1[0];
        for (int i = 1; i < nums1.length; i++) {
            max=Math.max(nums1[i],max);
            min=Math.max(nums1[i],min);
        }


        //计算桶个数（当然，个数可以自由定义）
        int buckNum=(max-min)/nums1.length+1;

        //创建桶
        ArrayList<ArrayList<Integer>> buckList=new ArrayList<>();
        for (int i = 0; i < buckNum; i++) {
            buckList.add(new ArrayList<>());
        }

        //将元素放入对应范围的桶中
        for (int i = 0; i < nums1.length; i++) {
            buckList.get((nums1[i]-min)/nums1.length).add(nums1[i]);
        }

        //将每个桶中的元素排序
        for (ArrayList<Integer> list : buckList) {
            Collections.sort(list);
        }

        int[] res=new int[nums1.length];
        int index=0;
        for (ArrayList<Integer> buck : buckList) {
            for (Integer bu : buck) {
                res[index++]=bu;
            }
        }

        return res;
        
    }


    public static void main(String[] args) {
        int[] nums={4,4,2,2,7,3,3,8,10};
//        int[] res=CountSort(nums);
        int[] res=buckSort(nums);
        for (int re : res) {
            System.out.print(re+" ");
        }


//        SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Timestamp ts=new Timestamp(1633881600000L);
//
//        System.out.println(df.format(ts));

    }

}
