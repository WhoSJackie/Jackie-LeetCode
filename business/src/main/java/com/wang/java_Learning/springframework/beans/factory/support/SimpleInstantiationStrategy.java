package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if (ctor!=null) {
                return clazz.getDeclaredConstructor().newInstance(args);
            } else{
                return clazz.getDeclaredConstructor().newInstance();
            }
        }  catch (InstantiationException  | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }
}
