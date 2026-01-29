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
    public Object getBean(String name,Object... args) {
        Object bean = getSingleton(name);
        if (bean!=null){
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name,beanDefinition,args);
    }

    @Override
    public <T> T getBean(String name, Class<T> requiredType) {
        Object bean = this.getBean(name);
        if (requiredType!=null && !requiredType.isInstance(bean)){
            throw new BeansException("Bean named '" + name + "' is expected to be of type '" + requiredType.getTypeName() + "' but was actually of type '" + bean.getClass().getTypeName() + "'");
        }
        return (T) bean;
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
        if (!(beanInstance instanceof BeanFactory)){
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
