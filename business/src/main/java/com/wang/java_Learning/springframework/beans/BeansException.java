package com.wang.java_Learning.springframework.beans;

public class BeansException extends RuntimeException{

    public BeansException(String msg){
        super(msg);
    }

    public BeansException(String msg,Exception ex){
        super(msg,ex);
    }

}
