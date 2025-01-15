package com.wang.java_Learning.proxy;

public class TestProxy {

    public static void main(String[] args) {
        Shape shape=new Tangle();
        MyHandlerInvocation handlerInvocation=new MyHandlerInvocation(shape);
        Shape proxy = (Shape)handlerInvocation.getProxy();
        proxy.printShape();

    }
}
