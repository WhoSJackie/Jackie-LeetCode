package com.wang.java_Learning.collection;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

public class PriQueue {

    public static String selectColor(String[] colorArr,int[] weightArr){
        int length = colorArr.length;
        int totalWeight = 0;
        boolean sameWeight = true;
        for (int i = 0; i < length; i++) {
            totalWeight+=weightArr[i];
            if (sameWeight && totalWeight!=weightArr[i]*(i+1)){
                sameWeight = false;
            }
        }

        if (!sameWeight && totalWeight>0){
            int offset = ThreadLocalRandom.current().nextInt();
            System.out.println(offset);
            for (int i = 0; i < length; i++) {
                if (offset<weightArr[i]){
                    return colorArr[i];
                }
            }
        }
        return colorArr[ThreadLocalRandom.current().nextInt(length)];
    }

    public static void main(String[] args) {
//        PriorityQueue<Integer> queue = new PriorityQueue<Integer>((a,b)-> Integer.compare(0, a-b));
//        queue.offer(1);
//        queue.offer(5);
//        queue.offer(3);
//        queue.offer(7);
//        queue.offer(2);
//        System.out.println(queue.peek());
        List<String> strList = Arrays.asList("a");
        strList = Optional.ofNullable(strList).orElse(new ArrayList<>());
        strList.stream().filter(i->"a".equals(i)).collect(Collectors.toList());
        for (String s : strList) {
            System.out.println(s);
        }
    }




}
