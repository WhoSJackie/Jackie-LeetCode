package com.wang.javaL.proxy;

public class TestProxy {

    public static void main(String[] args) {
        Shape shape=new Tangle();
        MyHandlerInvocation handlerInvocation=new MyHandlerInvocation(shape);
        Shape proxy = (Shape)handlerInvocation.getProxy();
        proxy.printShape();

    }
}
