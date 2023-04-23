package com.wang.java_Learning.generic;

public class TestGenericImpl<T> implements TestGenericInterface<String> {
    @Override
    public String getTest() {
        return "test";
    }
}
