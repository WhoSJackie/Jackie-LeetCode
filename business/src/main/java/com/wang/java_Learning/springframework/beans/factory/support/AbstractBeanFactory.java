package com.wang.java_Learning.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.BeanFactory;
import com.wang.java_Learning.springframework.beans.factory.FactoryBean;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanPostProcessor;
import com.wang.java_Learning.springframework.utils.ClassUtils;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class AbstractBeanFactory extends FactoryBeanRegistrySupport implements BeanFactory {

    /**
     * ClassLoader to resolve bean class names with, if necessary
     */
    private ClassLoader beanClassLoader = ClassUtils.getDefaultClassLoader();

    @Override
    public Object getBean(String name) {
        return doGetBean(name,null);
    }

    @Override
    public Object getBean(String name,Object... args) {
        return doGetBean(name,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        return (T)getBean(name);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName,BeanDefinition beanDefinition,Object[] args);

    public ClassLoader getBeanClassLoader() {
        return this.beanClassLoader;
    }

    protected <T>T doGetBean(final String  name, final Object[] args){
        Object sharedInstance = getSingleton(name);
        if (sharedInstance !=null){
            return (T) getObjectForBeanInstance(sharedInstance,name);
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        Object bean = createBean(name, beanDefinition, args);
        return (T) getObjectForBeanInstance(bean,name);
    }

    private Object getObjectForBeanInstance(Object beanInstance,String beanName){
        if (!(beanInstance instanceof FactoryBean)){
            return beanInstance;
        }
        Object object = getCachedObjectForFactoryBean(beanName);
        if (object==null){
            FactoryBean<?> factoryBean = (FactoryBean<?>) beanInstance;
            object = getObjectFromFactoryBean(factoryBean, beanName);
        }
        return object;
    }

}
