package com.wang.java_Learning.springframework.beans.factory.support;

import com.wang.common.utils.StringUtils;
import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.DisposableBean;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

public class DisposableBeanAdapter implements DisposableBean {

    private String beanName;

    private Object bean;

    private String destroyMethodName;

    public DisposableBeanAdapter(String beanName, Object bean, BeanDefinition beanDefinition) {
        this.beanName = beanName;
        this.bean = bean;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) ((DisposableBean) bean).destroy();

        // 2. 配置信息 destroy-method {判断是为了避免二次执行销毁}
        if (!StringUtils.isEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy" .equals(destroyMethodName))){
            Method method = bean.getClass().getMethod(destroyMethodName);
            if (null == method) throw new BeansException("Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            method.invoke(bean);
        }
    }
}
