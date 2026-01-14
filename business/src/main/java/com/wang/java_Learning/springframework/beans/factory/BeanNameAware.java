package com.wang.java_Learning.springframework.beans.factory;

import cn.hutool.core.bean.BeanException;

public interface BeanNameAware extends Aware{

    void setBeanName(String name);

}
