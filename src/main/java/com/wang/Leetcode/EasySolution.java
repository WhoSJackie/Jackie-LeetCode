package com.wang.Leetcode;


import java.util.*;

public class EasySolution {

    public String convertToTitle(int columnNumber) {
        StringBuilder sb  =new StringBuilder();
        while (columnNumber!=0){
            columnNumber--;
            sb.append((char)('A'+columnNumber%26));
            columnNumber = columnNumber/26;
        }
        return sb.reverse().toString();
    }

    public int findMaxConsecutiveOnes(int[] nums) {
        int cnt=0;
        int max = 0;
        int len  = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i]!=1){
                max = Math.max(max,cnt);
                cnt=0;
            } else{
                cnt++;
            }
        }
        max = Math.max(max,cnt);
        return max;
    }

    public int thirdMax(int[] nums) {
        int len = nums.length;
        // 小于3个
        if (len<3){
            if (len==1) return nums[0];
            return Math.max(nums[0],nums[1]);
        }
        // 大于等于三个
        Arrays.sort(nums);
        int cnt=1;
        for (int i = len-2; i >=0; i--) {
            if (nums[i]<nums[i+1]) cnt++;
            if (cnt==3) return nums[i];
        }
        if (cnt<3) return nums[len-1];
        return cnt;
    }

    public int maximumProduct(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);
        return Math.max(nums[len-1]*nums[len-2]*nums[len-3],nums[len-1]*nums[0]*nums[1]);
    }


    public int findShortestSubArray(int[] nums) {
        int len = nums.length;
        Map<Integer,int[]> dataMap = new HashMap<>();
        int maxDeg = 0;
        int minRange = 0;
        // 1.1 统计最大的度,统计每个数的度
        for (int i = 0; i < len; i++) {
            int[] curArr = dataMap.getOrDefault(nums[i],new int[]{0,i,i});
            // 处理度
            curArr[0]++;
            // 处理范围
            curArr[2] = i;
            dataMap.put(nums[i],curArr);
        }
        // 1.3 找到最大度的最小连续子串长度
        for (Map.Entry<Integer, int[]> entry : dataMap.entrySet()) {
            int[] tmpArr = entry.getValue();
            // 符合最大度
            if (maxDeg<tmpArr[0]){
                maxDeg = tmpArr[0];
                minRange = tmpArr[2]-tmpArr[1]+1;
            }else if (tmpArr[0]==maxDeg){
                if (tmpArr[2]-tmpArr[1]+1<minRange){
                    minRange = tmpArr[2]-tmpArr[1]+1;
                }
            }
        }
        return minRange;
    }


    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        int[] norNums = new int[n+1];
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            norNums[nums[i]]++;
        }
        // 找到确实的数字
        for (int i = 1; i <= n; i++) {
            if (norNums[i]==0) res.add(i);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(new EasySolution().findDisappearedNumbers(new int[]{1,1}));
    }

}
