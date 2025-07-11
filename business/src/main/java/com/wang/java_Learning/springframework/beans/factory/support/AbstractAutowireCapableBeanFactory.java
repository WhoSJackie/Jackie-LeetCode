package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private JDKInstantiationStrategy jdkInstantiationStrategy = new JDKInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName,beanDefinition,args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(beanName,bean);
        return bean;
    }

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition) {
        Object bean = null;
        try {
            bean = beanDefinition.getBeanClass().newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        addSingleton(beanName,bean);
        return bean;
    }

    protected  Object createBeanInstance(String beanName, BeanDefinition beanDefinition,Object[] args){
        Constructor ctor = null;
        Class beanClass = beanDefinition.getBeanClass();
        Constructor[] declaredConstructors = beanClass.getDeclaredConstructors();
        for (Constructor constructor : declaredConstructors) {
            if (constructor!=null && args.length == constructor.getParameterTypes().length){
                ctor = constructor;
                break;
            }
        }
        return jdkInstantiationStrategy.instantiate(beanDefinition,beanName,ctor,args);
    }









}
