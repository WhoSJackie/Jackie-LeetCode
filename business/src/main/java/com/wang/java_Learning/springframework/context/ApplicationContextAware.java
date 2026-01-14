package com.wang.java_Learning.springframework.context;

import cn.hutool.core.bean.BeanException;
import com.wang.java_Learning.springframework.beans.factory.Aware;

public interface ApplicationContextAware extends Aware {

    void setApplicationContext(ApplicationContext applicationContext) throws BeanException;

}
