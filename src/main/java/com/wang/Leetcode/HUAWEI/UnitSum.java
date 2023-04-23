package com.wang.Leetcode.HUAWEI;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UnitSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 法一 O(n^2)
//        int a = Integer.parseInt(in.nextLine());
//        String arrStr1 = in.nextLine();
//        int b = Integer.parseInt(in.nextLine());
//        String arrStr2 = in.nextLine();
//
//        int[] arr1 = Arrays.stream(arrStr1.split(" ")).mapToInt(Integer::valueOf).toArray();
//        int[] arr2 = Arrays.stream(arrStr2.split(" ")).mapToInt(Integer::valueOf).toArray();
//        int cnt = 0;
//        for (int i = 0; i < a; i++) {
//            for (int j = 0; j < b; j++) {
//                if (arr1[i]==arr2[j]) cnt++;
//            }
//        }

        // 法2使用hashmap O(n)
        int a = in.nextInt();
        HashMap<Integer,Integer> map_a = new HashMap<>();
        for (int i = 0; i < a; i++) {
            int b = in.nextInt();
            if (map_a.containsKey(b)){
                map_a.put(b,map_a.get(b)+1);
            } else{
                map_a.put(b,1);
            }
        }
        int c = in.nextInt();
        Map<Integer,Integer> map_b = new HashMap<>();
        for (int i = 0; i < c; i++) {
            int d = in.nextInt();
            if (map_b.containsKey(d)){
                map_b.put(d,map_b.get(d)+1);
            } else{
                map_b.put(d,1);
            }
        }
        int cnt = 0;
        // 统计二元组
        for (Map.Entry<Integer,Integer> x : map_a.entrySet()){
            if (map_b.containsKey(x.getKey())){
                cnt+=x.getValue()*map_b.get(x.getKey());
            }
        }

        System.out.println(cnt);
    }


}
