package com.wang.javaL.defaultTest;

public interface PersonA {

    public default void a(){
        System.out.println("实现接口-->PersonA");
    }
}
