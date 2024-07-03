package com.wang.learning;

import java.util.*;

public class No506 {

    public String[] findRelativeRanks(int[] score) {
        //法一，hashmap
//        int len=score.length;
//        String[] ans=new String[len];
//        Map<Integer,Integer> sortMap=new HashMap<>();
//        //sortMap存放<运动员编号，运动员成绩>
//        for (int i = 0; i < len; i++) {
//            sortMap.put(i,score[i]);
//        }
//        List<Map.Entry<Integer,Integer>> list=new ArrayList<>(sortMap.entrySet());
//        Collections.sort(list, (o1, o2) -> {
//            if(o1.getValue()<o2.getValue()){
//                return 1;
//            }
//
//            else if(o1.getValue()>o2.getValue()){
//                return -1;
//            }
//            else{
//                return 0;
//            }
//        });
//
//
//        int index=0;
//        for (Map.Entry<Integer, Integer> s: list) {
//            Integer num=s.getKey();
//            if(index==0){
//                ans[num]="Gold Medal";
//                index++;
//                continue;
//            }
//            if(index==1){
//                ans[num]="Silver Medal";
//                index++;
//                continue;
//            }
//            if(index==2){
//                ans[num]="Bronze Medal";
//                index++;
//                continue;
//            }
//            ans[num]=String.valueOf(++index);
//        }
//
//        return ans;


        //法二 计数排序+双数组
        String[] ans = new String[score.length];
        int max = score[0];
        int min = score[0];
        for (int i = 1; i < score.length; i++) {
            max = Math.max(max, score[i]);
            min = Math.min(min, score[i]);
        }
        //分数排序
        int[] sort = new int[max - min + 1];
        Arrays.fill(sort, -1);
        //对应的运动员编号
        int[] index = new int[max - min + 1];
        for (int i = 0; i < score.length; i++) {
            sort[score[i] - min] = score[i];
            index[score[i] - min] = i;
        }

        int ind = 0;
        for (int i = sort.length - 1; i >= 0; i--) {
            if (sort[i] != -1) {
                if (ind == 0) {
                    ans[index[i]] = "Gold Medal";
                    ind++;
                    continue;
                }
                if (ind == 1) {
                    ans[index[i]] = "Silver Medal";
                    ind++;
                    continue;
                }
                if (ind == 2) {
                    ans[index[i]] = "Bronze Medal";
                    ind++;
                    continue;
                }
                ans[index[i]] = String.valueOf(++ind);
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        int[] score={10,3,8,9,4};
        String[] relativeRanks = new No506().findRelativeRanks(score);
        for (String rank : relativeRanks) {
            System.out.println(rank);
        }
    }
}
