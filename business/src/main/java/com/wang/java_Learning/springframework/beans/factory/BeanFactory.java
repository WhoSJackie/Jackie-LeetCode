package com.wang.java_Learning.springframework.beans.factory;

public interface BeanFactory {

    Object getBean(String name,Object... args);

    <T> T getBean(String name,Class<T> requiredType);
}
