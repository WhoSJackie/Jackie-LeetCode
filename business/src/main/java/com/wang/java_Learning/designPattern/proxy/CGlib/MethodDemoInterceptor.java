package com.wang.java_Learning.designPattern.proxy.CGlib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MethodDemoInterceptor implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before invoke method:"+method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after invoke method:"+method.getName());
        return object;
    }
}
