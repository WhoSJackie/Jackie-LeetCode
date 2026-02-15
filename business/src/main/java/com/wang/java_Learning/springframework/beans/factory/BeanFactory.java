package com.wang.java_Learning.springframework.beans.factory;

import com.wang.java_Learning.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name,Object... args);

    <T> T getBean(String name,Class<T> requiredType);
}
