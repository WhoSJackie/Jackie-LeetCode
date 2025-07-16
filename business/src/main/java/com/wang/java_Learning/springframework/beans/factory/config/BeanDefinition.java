package com.wang.java_Learning.springframework.beans.factory.config;

import com.wang.java_Learning.springframework.beans.factory.support.PropertyValue;
import com.wang.java_Learning.springframework.beans.factory.support.PropertyValues;

public class BeanDefinition {

    private Class beanClass;

    private PropertyValues propertyValues;

    public BeanDefinition(Class beanClass){
        this.beanClass = beanClass;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class beanClass, PropertyValues propertyValue){
        this.beanClass = beanClass;
        this.propertyValues = propertyValue == null ? new PropertyValues():propertyValue;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class beanClass) {
        this.beanClass = beanClass;
    }

    public PropertyValues getPropertyValue() {
        return propertyValues;
    }

    public void setPropertyValue(PropertyValues propertyValues) {
        this.propertyValues = propertyValues;
    }
}
