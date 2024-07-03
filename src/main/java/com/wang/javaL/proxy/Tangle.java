package com.wang.javaL.proxy;

public class Tangle implements Shape{

    @Override
    public void printShape() {
        String temp=this.getClass().getName();
        String[] split = temp.split("\\.");
        System.out.println("this is :"+split[split.length-1]);
    }
}
