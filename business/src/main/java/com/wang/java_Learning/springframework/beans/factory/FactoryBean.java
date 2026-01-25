package com.wang.java_Learning.springframework.beans.factory;

public interface FactoryBean<T> {

    T getObject() throws Exception;

    Class<T> getObjectType();

    boolean isSingletion();


}
