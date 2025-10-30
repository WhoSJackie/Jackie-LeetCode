package com.wang.java_Learning.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.lang.Assert;
import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.ConfigurableListableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanPostProcessor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class DefaultListableBeanFactory extends AbstractAutowireCapableBeanFactory implements ConfigurableListableBeanFactory,BeanDefinitionRegistry{
    Map<String,BeanDefinition> beanDefinitionMap = new HashMap<>();
    private final List<BeanPostProcessor> beanPostProcessors = new CopyOnWriteArrayList();
    @Override
    public BeanDefinition getBeanDefinition(String beanName) {
        BeanDefinition definition = beanDefinitionMap.get(beanName);
        if (definition==null) throw new BeansException("no bean '"+beanName+"' is defined");
        return definition;
    }

    @Override
    public void preInstantiateSingletons() throws BeansException {

    }

    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }

    @Override
    public <T> Map<String, T> getBeansOfType(Class<T> var) {
        Map<String,T> result = new HashMap<>();
        BeanDefinition beanDefinition = beanDefinitionMap.get(var.getName());
        Object bean = null;
        if (null == beanDefinition){
            for (Map.Entry<String, BeanDefinition> map : beanDefinitionMap.entrySet()) {
                Class[] interfaces = map.getValue().getBeanClass().getInterfaces();
                if (interfaces.length==0) continue;
                String parentClassName = interfaces[0].getName();
                if (parentClassName.equals(var.getName())){
                    bean = getBean(map.getKey());
                    result.put(map.getKey(),(T)bean);
                }
            }
        } else{
            bean = getBean(var.getName());
            result.put(var.getName(),(T)bean);
        }
        return result;
    }


    @Override
    public void registryBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName,beanDefinition);
    }

    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    @Override
    public void addBeanPostProcessor(BeanPostProcessor beanPostProcessor) {
        Assert.notNull(beanPostProcessor, "BeanPostProcessor must not be null");
        this.beanPostProcessors.add(beanPostProcessor);
    }

    @Override
    public int getBeanPostProcessorCount() {
        return this.beanPostProcessors.size();
    }

    @Override
    public void destroySingletons() {
        super.destroySingletons();
    }

    @Override
    protected List<BeanPostProcessor> getBeanPostProcessors() {
        return this.beanPostProcessors;
    }


}
