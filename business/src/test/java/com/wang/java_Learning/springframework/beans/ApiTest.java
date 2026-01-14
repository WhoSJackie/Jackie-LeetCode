package com.wang.java_Learning.springframework.beans;

import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanReference;
import com.wang.java_Learning.springframework.beans.factory.support.DefaultListableBeanFactory;
import com.wang.java_Learning.springframework.beans.factory.support.XmlBeanDefinitionReader;
import com.wang.java_Learning.springframework.context.support.ClassPathXmlApplicationContext;
import com.wang.java_Learning.springframework.postprocessor.MyBeanFactoryPostProcessor;
import com.wang.java_Learning.springframework.postprocessor.MyBeanPostProcessor;
import org.junit.Test;

public class ApiTest {

    @Test
    public void testProperValues() {
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.注入bean
        beanFactory.registryBeanDefinition("apiDao",new BeanDefinition(ApiDao.class));

        // apiService设置属性
        PropertyValues propertyValues = new PropertyValues();
        PropertyValue propertyValue1 = new PropertyValue("uid","10001");
        PropertyValue propertyValue2 = new PropertyValue("apiDao",new BeanReference("apiDao"));
        propertyValues.addPropertyValue(propertyValue1);
        propertyValues.addPropertyValue(propertyValue2);

        // 注入apiService
        BeanDefinition beanDefinition = new BeanDefinition(ApiService.class,propertyValues);
        beanFactory.registryBeanDefinition("apiService",beanDefinition);

        // 获取bean并且测试
        ApiService bean = (ApiService)beanFactory.getBean("apiService");
        bean.testService();
    }
    @Test
    public void testXml(){
        // 1.初始化beanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2.读取xml配置，注入bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3.BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessorBeanFactory(beanFactory);

        // 4.bean实例化完成后，修改属性
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5.获取bean并且测试
        ApiService bean = (ApiService)beanFactory.getBean("apiService");
        bean.testService();
    }

    @Test
    public void testApplicationContext(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();
        ApiService apiService = applicationContext.getBean("apiService", ApiService.class);
        apiService.testService();
        System.out.println("ApplicationContextAware："+apiService.getApplicationContext());
        System.out.println("BeanFactoryAware："+apiService.getBeanFactory());
    }


}
