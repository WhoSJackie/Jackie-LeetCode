package com.wang.Leetcode;


import java.io.File;
import java.util.*;

public class EasySolution {

    private int i;

    public int inc(int m){
        return m+i;
    }

    public int tryCatch(){
        int i;
        try{
            i = 1;
            return i;
        } catch(Exception e){
            i = 2;
            return i;
        } finally{
            i = 3;
        }
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        if (words.length==1) return Arrays.asList(words);
        List<String> list = new ArrayList<>();
        int i=0;
        int len = words.length;
        list.add(words[i++]);
        while (i<len){
            if (groups[i]!=groups[i-1]) list.add(words[i]);
            i++;
        }
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resSet = new HashSet<>();
        int len = nums.length;
        Arrays.sort(nums);
        int l = 0,r = 0;
        for (int i = 0; i < len; i++) {
            l = i+1;
            r = len-1;
            while (l<r){
                int temp = nums[i]+nums[l]+nums[r];
                if (temp>0)r--;
                else if (temp<0) l++;
                else {
                    resSet.add(Arrays.asList(nums[i],nums[l],nums[r]));
                    l++;
                    r--;
                }
            }
        }
        return new ArrayList<>(resSet);
    }

    public static void main(String[] args) {
        java.io.File  fileDir = new java.io.File("D:\\home\\wjblog\\");
        java.io.File[] files = fileDir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }


}
