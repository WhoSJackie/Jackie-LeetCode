package com.wang.java_Learning.springframework.beans.factory;

public interface InitializingBean {

    void afterPropertiesSet() throws Exception;

}
