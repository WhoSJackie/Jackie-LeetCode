package com.wang.java_Learning.springframework.bean;

public class ApiService {

    private String name;

    public ApiService(String name){
        this.name = name;
    }

    public void testService(){
        System.out.println("get name:"+name);
    }

}
