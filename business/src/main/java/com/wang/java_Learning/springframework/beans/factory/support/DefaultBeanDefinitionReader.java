package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.java_Learning.springframework.core.io.DefaultResourceLoader;
import com.wang.java_Learning.springframework.core.io.Resource;
import com.wang.java_Learning.springframework.core.io.ResourceLoader;

public abstract class DefaultBeanDefinitionReader implements BeanDefinitionReader{

    private final BeanDefinitionRegistry registry;

    private ResourceLoader resourceLoader;

    public DefaultBeanDefinitionReader(BeanDefinitionRegistry registry){
        this(registry,new DefaultResourceLoader());
    }

    public DefaultBeanDefinitionReader(BeanDefinitionRegistry registry,ResourceLoader resourceLoader){
        this.registry = registry;
        this.resourceLoader = resourceLoader;
    }

    @Override
    public BeanDefinitionRegistry getRegistry() {
        return this.registry;
    }

    @Override
    public ResourceLoader getResourceLoader() {
        return this.resourceLoader;
    }
}
