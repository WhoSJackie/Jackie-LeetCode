package com.wang.java_Learning.springframework.beans.factory;

import cn.hutool.core.bean.BeanException;

public interface BeanFactoryAware extends Aware{

    void setBeanFactory(BeanFactory beanFactory) throws BeanException;

}
