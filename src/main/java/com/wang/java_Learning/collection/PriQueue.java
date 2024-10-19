package com.wang.java_Learning.collection;

import java.util.*;
import java.util.stream.Collectors;

public class PriQueue {

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
