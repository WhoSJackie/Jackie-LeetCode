package com.wang.javaL.contextTest;

import java.util.HashMap;
import java.util.Map;

public class ContextTest {

    Map<String,String> map = new HashMap<>();
    {
        map.put("1","test1");
        map.put("2","test2");
    }

    public static void main(String[] args) {
        ContextTest contextTest = new ContextTest();
        Map<String,String> tempMap = contextTest.map;
        for (String s : tempMap.keySet()) {
            System.out.println(tempMap.get(s));
        }
    }
}
