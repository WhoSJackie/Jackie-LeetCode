package com.wang.java_Learning.springframework.beans.api;

import java.util.HashMap;
import java.util.Map;

public class ApiDao {

    private static Map<String,String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Jackie");
        hashMap.put("10002", "Maggie");
        hashMap.put("10003", "Toby");
    }

    public String queryUserName(String uId) {
        return hashMap.get(uId);
    }

    public void initDataMethod(){
        System.out.println("init data!");
    }
    public void destroyDataMethod(){
        System.out.println("destroy data!");
    }

}
