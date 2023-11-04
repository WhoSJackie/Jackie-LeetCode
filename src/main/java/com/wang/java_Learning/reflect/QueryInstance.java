package com.wang.java_Learning.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class QueryInstance {

    public static void main(String[] args) throws Exception {
        Class<?> aClass = Class.forName("com.wang.java_Learning.reflect.TestExample");
        Object instance = aClass.newInstance();

        Method[] methods = aClass.getDeclaredMethods();
        System.out.println("Below is methods names:");
        for (Method method : methods) {
            System.out.println(method.getName());
        }

        Method meth = aClass.getDeclaredMethod("getValue", String.class);
        Object res = meth.invoke(instance, "Reflect method");
        System.out.println(res);

        Field[] fields = aClass.getDeclaredFields();
        System.out.println("Below is fields names:");
        for (Field field : fields) {
            System.out.println(field.getName());
        }
    }


}
