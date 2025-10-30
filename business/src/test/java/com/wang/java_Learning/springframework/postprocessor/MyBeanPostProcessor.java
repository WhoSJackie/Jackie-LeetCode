package com.wang.java_Learning.springframework.postprocessor;

import com.wang.java_Learning.springframework.beans.ApiService;
import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("apiService".equals(beanName)){
            ApiService apiService = (ApiService)bean;
            apiService.setLocation("改为：上海");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
