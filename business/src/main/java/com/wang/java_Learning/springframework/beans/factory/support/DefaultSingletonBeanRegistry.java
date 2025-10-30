package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.java_Learning.springframework.beans.factory.DisposableBean;
import com.wang.java_Learning.springframework.beans.factory.config.ConfigurableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.config.SingletonBeanRegistry;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String,Object> singletonObjects = new HashMap<>();

    private final Map<String, Object> disposableBeans = new LinkedHashMap();

    @Override
    public Object getSingleton(String beanName) {
        return singletonObjects.get(beanName);
    }

    protected void addSingleton(String beanName,Object singletonObject){
        singletonObjects.put(beanName,singletonObject);
    }

    protected void registerDisposableBean(String beanName, DisposableBean disposableBean){
        disposableBeans.put(beanName,disposableBean);
    }

    void destroySingletons(){
        for (Object value : disposableBeans.values()) {
            if (value instanceof DisposableBeanAdapter) {
                try {
                    ((DisposableBeanAdapter) value).destroy();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
