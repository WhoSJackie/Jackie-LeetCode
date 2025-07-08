package com.wang.java_Learning.designPattern.proxy.CGlib;

public class AlismsService {

    public String sendMessage(String message){
        System.out.println("send message:"+message);
        return message;
    }

}
