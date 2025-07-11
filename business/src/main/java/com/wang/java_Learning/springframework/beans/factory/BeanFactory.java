package com.wang.java_Learning.springframework.beans.factory;

public interface BeanFactory {

    Object getBean(String name);

    Object getBean(String name,Object... args);

}
