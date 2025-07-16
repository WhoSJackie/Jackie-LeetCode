package com.wang.java_Learning.springframework.beans;

import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanReference;
import com.wang.java_Learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.support.PropertyValue;
import com.wang.java_Learning.springframework.beans.factory.support.PropertyValues;
import com.wang.java_Learning.springframework.beans.factory.support.XmlBeanDefinitionReader;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testProperValues() {
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        beanFactory.registryBeanDefinition("apiDao",new BeanDefinition(ApiDao.class));

        // apiService设置属性
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue propertyValue1 = new PropertyValue("uid","10001");
        PropertyValue propertyValue2 = new PropertyValue("apiDao",new BeanReference("apiDao"));
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);

        // 注入apiService
        BeanDefinition beanDefinition = new BeanDefinition(ApiService.class,propertyValues);
        beanFactory.registryBeanDefinition("apiService",beanDefinition);

        // 获取bean并且测试
        ApiService bean = (ApiService)beanFactory.getBean("apiService");
        bean.testService();
    }
    @Test
    public void testXml(){
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 读取xml配置，注入bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 获取bean并且测试
        ApiService bean = (ApiService)beanFactory.getBean("apiService");
        bean.testService();
    }



}
