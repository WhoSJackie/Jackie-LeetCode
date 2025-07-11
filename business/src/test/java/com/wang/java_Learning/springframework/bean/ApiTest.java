package com.wang.java_Learning.springframework.bean;

import com.wang.java_Learning.springframework.beans.factory.BeanFactory;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.support.DefaultListableBeanFactory;

public class ApiTest {

    public static void main(String[] args) {
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        BeanDefinition beanDefinition = new BeanDefinition(ApiService.class);
        beanFactory.registryBeanDefinition("ApiService",beanDefinition);

        // 2.注入bean
        ApiService bean = (ApiService)beanFactory.getBean("ApiService", "jackie");
        bean.testService();
    }

}
