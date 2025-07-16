package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.core.io.Resource;
import com.wang.java_Learning.springframework.core.io.ResourceLoader;

public interface BeanDefinitionReader {

    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

}
