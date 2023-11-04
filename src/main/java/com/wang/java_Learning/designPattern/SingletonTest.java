package com.wang.java_Learning.designPattern;

public class SingletonTest {

    private SingletonTest(){}

    private  static SingletonTest singleton= null;

    public SingletonTest getSingleton(){
        if (singleton==null){
            synchronized (SingletonTest.class){
                if (singleton==null){
                    singleton = new SingletonTest();
                }
            }
        }
        return singleton;
    }

}
