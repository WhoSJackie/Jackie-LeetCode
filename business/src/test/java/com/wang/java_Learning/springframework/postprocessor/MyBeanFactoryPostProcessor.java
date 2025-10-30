package com.wang.java_Learning.springframework.postprocessor;

import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanFactoryPostProcessor;
import com.wang.java_Learning.springframework.beans.factory.support.PropertyValue;
import com.wang.java_Learning.springframework.beans.factory.support.PropertyValues;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessorBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("apiService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company","改为：华鑫证券"));
    }
}
