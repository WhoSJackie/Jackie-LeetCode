package com.wang.java_Learning.springframework.beans.factory;

import java.util.List;
import java.util.Map;

public interface ListableBeanFactory extends BeanFactory{

    String[] getBeanDefinitionNames();

    <T> Map<String, T> getBeansOfType (Class<T> var);

}
