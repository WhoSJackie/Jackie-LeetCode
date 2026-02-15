package com.wang.java_Learning.springframework.beans.api;

import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.factory.*;
import com.wang.java_Learning.springframework.context.ApplicationContext;
import com.wang.java_Learning.springframework.context.ApplicationContextAware;
import lombok.Data;

@Data
public class ApiService implements InitializingBean, DisposableBean, BeanClassLoaderAware, BeanNameAware, BeanFactoryAware, ApplicationContextAware {

    private String uid;

    private ApiDao apiDao;

    private String location;

    private String company;

    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    public void testService(){
        System.out.println("name is: "+apiDao.queryUserName(uid));
        System.out.println("company is: "+this.company);
        System.out.println("location is: "+this.location);
    }



    @Override
    public void destroy() throws Exception {
        System.out.println("destroy!");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }
}
