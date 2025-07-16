package com.wang.java_Learning.springframework.beans.factory.support;

import cn.hutool.core.bean.BeanException;
import cn.hutool.core.bean.BeanUtil;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanReference;

import java.lang.reflect.Constructor;

public abstract class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory{

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition,Object[] args) {
        Object bean = null;
        try {
            bean = createBeanInstance(beanName,beanDefinition,args);
            applyPropertyValues(beanName,bean,beanDefinition);
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
        return getInstantiationStrategy().instantiate(beanDefinition,beanName,ctor,args);
    }

    protected void applyPropertyValues(String beanName,Object bean,BeanDefinition beanDefinition){
        try{
            PropertyValues propertyValues = beanDefinition.getPropertyValue();
            for (PropertyValue propertyValue : propertyValues.getPropertyValues()) {
                String name = propertyValue.getName();
                Object value = propertyValue.getValue();

                if (value instanceof BeanReference){
                    BeanReference beanReference = (BeanReference) value;
                    value = getBean(beanReference.getBeanName());
                }
                // 属性填充
                BeanUtil.setFieldValue(bean,name,value);
            }
        } catch (Exception e){
            throw new BeanException("Error setting property values: "+ beanName+" error is:"+e.toString());
        }
    }

    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy){
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy(){
        return this.instantiationStrategy;
    }


}
