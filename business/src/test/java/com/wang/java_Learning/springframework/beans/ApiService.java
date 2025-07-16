package com.wang.java_Learning.springframework.beans;

public class ApiService {

    private String uid;

    private ApiDao apiDao;

    public void testService(){
        System.out.println("name is: "+apiDao.queryUserName(uid));
    }

}
