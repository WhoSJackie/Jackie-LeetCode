package com.wang.java_Learning.designPattern.proxy;

import com.wang.java_Learning.designPattern.proxy.CGlib.AlismsService;
import com.wang.java_Learning.designPattern.proxy.CGlib.CGlibProxyFactory;
import com.wang.java_Learning.designPattern.proxy.JdkProxy.MyHandlerInvocation;
import com.wang.java_Learning.designPattern.proxy.JdkProxy.Shape;
import com.wang.java_Learning.designPattern.proxy.JdkProxy.Tangle;

public class TestProxy {

    public static void main(String[] args) {
        // JDK proxy
//        Shape shape=new Tangle();
//        MyHandlerInvocation handlerInvocation=new MyHandlerInvocation(shape);
//        Shape proxy = (Shape)handlerInvocation.getProxy();
//        proxy.printShape();

        // CGlib proxy
        AlismsService proxy = (AlismsService)CGlibProxyFactory.getProxy(AlismsService.class);
        proxy.sendMessage("hello proxy!");
    }
}
