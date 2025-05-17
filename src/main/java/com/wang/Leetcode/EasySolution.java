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

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int len = words.length;
        int[] dp = new int[len];
        int[] pre = new int[len];
        int maxIndex=0;
        Arrays.fill(dp,1);
        Arrays.fill(pre,-1);
        for (int i = 1; i < len; i++) {
            for (int j=0;j<i;j++){
                if (isValid(words[i],words[j]) && dp[i]<dp[j]+1 && groups[i]!=groups[j]){
                    dp[i] = dp[j]+1;
                    pre[i] = j;
                }
            }
            if (dp[maxIndex]<dp[i]) maxIndex = i;
        }
        String[] strs = new String[dp[maxIndex]];
        int index= dp[maxIndex]-1;
        for (int x = maxIndex; x >=0; ) {
            strs[index--] = words[x];
            x = pre[x];
        }
        return Arrays.asList(strs);
    }

    private boolean isValid(String word1,String word2){
        if (word1.length()!=word2.length()) return false;
        int cnt=0;
        for (int i = 0; i < word1.length(); i++) {
            if (word1.charAt(i)!=word2.charAt(i)) cnt++;
            if (cnt>1) return false;
        }
        return cnt==1;
    }

    public static void main(String[] args) {
        java.io.File  fileDir = new java.io.File("D:\\home\\wjblog\\");
        java.io.File[] files = fileDir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }
    }


}
