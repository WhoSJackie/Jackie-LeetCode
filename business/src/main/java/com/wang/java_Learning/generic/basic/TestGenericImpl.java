package com.wang.java_Learning.generic.basic;

public class TestGenericImpl implements TestGenericInterface<String> {
    @Override
    public String getTest() {
        return "test";
    }
}
