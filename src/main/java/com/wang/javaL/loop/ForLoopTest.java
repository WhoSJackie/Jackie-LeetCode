package com.wang.javaL.loop;

import java.util.ArrayList;
import java.util.List;

public class ForLoopTest {

    public static void testForLoop(){
        List<Integer> num = new ArrayList<Integer>(){{
            add(1);
            add(2);
            add(3);
        }};
        Integer a = 0;
//        int i=0;
//        while ((a=num.get(i++))<=3){
//            System.out.println(a);
//        }
        for (int i=0;(a=num.get(i++))<=3;){
            System.out.println(a);
        }

    }


    public static void main(String[] args) {
        testForLoop();
    }


}
