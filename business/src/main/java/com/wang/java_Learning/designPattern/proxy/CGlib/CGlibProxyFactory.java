package com.wang.java_Learning.designPattern.proxy.CGlib;

import net.sf.cglib.proxy.Enhancer;

public class CGlibProxyFactory {

    public static Object getProxy(Class<?> clazz){
        Enhancer enhancer = new Enhancer();
        enhancer.setClassLoader(clazz.getClassLoader());
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(new MethodDemoInterceptor());
        return enhancer.create();
    }


}
