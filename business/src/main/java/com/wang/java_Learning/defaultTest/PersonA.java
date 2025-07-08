package com.wang.java_Learning.defaultTest;

public interface PersonA {

    public default void a(){
        System.out.println("实现接口-->PersonA");
    }
}
