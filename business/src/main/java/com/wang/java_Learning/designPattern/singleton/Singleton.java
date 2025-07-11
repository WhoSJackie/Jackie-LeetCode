package com.wang.java_Learning.designPattern.singleton;

/**
 * 饿汉式
 */
public class Singleton {

    private final static Singleton instance = new Singleton();

    private Singleton(){

    }

    public Singleton getInstance(){
        return instance;
    }



}
