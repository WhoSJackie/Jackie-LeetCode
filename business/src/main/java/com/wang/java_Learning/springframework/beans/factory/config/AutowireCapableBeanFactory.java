package com.wang.java_Learning.springframework.beans.factory.config;

import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.BeanFactory;

public interface AutowireCapableBeanFactory extends BeanFactory {

     Object applyBeanPostProcessorsBeforeInitialization(Object existingBean, String beanName) throws BeansException;

     Object applyBeanPostProcessorsAfterInitialization(Object existingBean, String beanName) throws BeansException;

}
