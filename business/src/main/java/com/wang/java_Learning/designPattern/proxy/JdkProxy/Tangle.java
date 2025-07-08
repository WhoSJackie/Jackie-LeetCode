package com.wang.java_Learning.designPattern.proxy.JdkProxy;

public class Tangle implements Shape{

    @Override
    public void printShape() {
        String temp = getClass().getName();
        String[] split = temp.split("\\.");
        System.out.println("this is :"+split[split.length-1]);
    }
}
