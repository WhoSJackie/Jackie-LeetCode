package com.wang.javaL.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class MyHandlerInvocation implements InvocationHandler {

    private Object target;

    public MyHandlerInvocation(){}

    public MyHandlerInvocation(Object target){
        this.target=target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before invoke...");
        Object invoke=method.invoke(target,args);
        System.out.println("after invoke...");
        return invoke;
    }

    //生成代理对象
    public Object getProxy(){
        ClassLoader classLoader=this.getClass().getClassLoader();
        Class<?>[] interfaces=target.getClass().getInterfaces();
        return Proxy.newProxyInstance(classLoader,interfaces,this);
    }

}
