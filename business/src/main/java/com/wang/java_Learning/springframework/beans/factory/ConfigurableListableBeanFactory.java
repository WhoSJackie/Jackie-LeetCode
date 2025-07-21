package com.wang.java_Learning.springframework.beans.factory;

import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.config.AutowireCapableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.ConfigurableBeanFactory;

public interface ConfigurableListableBeanFactory extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {

    BeanDefinition getBeanDefinition(String var1);

    void preInstantiateSingletons() throws BeansException;


}
