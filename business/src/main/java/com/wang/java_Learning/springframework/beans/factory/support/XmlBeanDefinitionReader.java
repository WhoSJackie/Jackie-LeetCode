package com.wang.java_Learning.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.XmlUtil;
import com.wang.common.utils.StringUtils;
import com.wang.java_Learning.springframework.beans.BeansException;
import com.wang.java_Learning.springframework.beans.PropertyValue;
import com.wang.java_Learning.springframework.beans.factory.config.BeanDefinition;
import com.wang.java_Learning.springframework.beans.factory.config.BeanReference;
import com.wang.java_Learning.springframework.core.io.Resource;
import com.wang.java_Learning.springframework.core.io.ResourceLoader;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import java.io.IOException;
import java.io.InputStream;

public class XmlBeanDefinitionReader extends DefaultBeanDefinitionReader{


    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    public XmlBeanDefinitionReader(BeanDefinitionRegistry registry, ResourceLoader resourceLoader) {
        super(registry, resourceLoader);
    }

    @Override
    public void loadBeanDefinitions(Resource resource) throws BeansException{
        try(InputStream inputstream = resource.getInputStream()) {
            doLoadBeanDefinitions(inputstream);
        } catch (IOException | ClassNotFoundException e){
            throw new BeansException("IOException parsing XML document from " + resource, e);
        }
    }

    @Override
    public void loadBeanDefinitions(Resource... resources) throws BeansException{
        for (Resource resource : resources) {
            loadBeanDefinitions(resource);
        }
    }

    @Override
    public void loadBeanDefinitions(String location) throws BeansException{
        ResourceLoader resourceLoader = getResourceLoader();
        Resource resource = resourceLoader.getResource(location);
        loadBeanDefinitions(resource);
    }

    @Override
    public void loadBeanDefinitions(String[] locations) throws BeansException {
        for (String location : locations) {
            this.loadBeanDefinitions(location);
        }
    }

    protected void doLoadBeanDefinitions(InputStream inputStream) throws ClassNotFoundException {
        Document document = XmlUtil.readXML(inputStream);
        Element root = document.getDocumentElement();
        NodeList childNodes = root.getChildNodes();

        for (int i = 0; i < childNodes.getLength(); i++) {
            if (!(childNodes.item(i) instanceof Element)) continue;
            if (!"bean".equals(childNodes.item(i).getNodeName())) continue;

            Element bean = (Element)childNodes.item(i);
            String id = bean.getAttribute("id");
            String name = bean.getAttribute("name");
            String className = bean.getAttribute("class");
            String beanScope = bean.getAttribute("scope");
            Class<?> clazz = Class.forName(className);

            // 获取init-method destroy-method
            String initMethod = bean.getAttribute("init-method");
            String destroyMethod = bean.getAttribute("destroy-method");

            String beanName = StrUtil.isNotEmpty(id)?id:name;
            if (StrUtil.isEmpty(beanName)) beanName = StrUtil.lowerFirst(clazz.getSimpleName());

            // 定义bean
            BeanDefinition beanDefinition = new BeanDefinition(clazz);
            beanDefinition.setInitMethodName(initMethod);
            beanDefinition.setDestroyMethodName(destroyMethod);

            if (!StringUtils.isEmpty(beanScope)){
                beanDefinition.setScope(beanScope);
            }

            for (int j = 0; j < bean.getChildNodes().getLength(); j++) {
                if (!(bean.getChildNodes().item(j) instanceof Element)) continue;
                if (!"property".equals(bean.getChildNodes().item(j).getNodeName())) continue;
                Element property = (Element)bean.getChildNodes().item(j);
                String attrName = property.getAttribute("name");
                String attrValue = property.getAttribute("value");
                String attrRef = property.getAttribute("ref");
                // 注入属性（对象/值）
                Object value = StrUtil.isNotEmpty(attrRef)?new BeanReference(attrRef):attrValue;
                PropertyValue propertyValue = new PropertyValue(attrName,value);
                beanDefinition.getPropertyValues().addPropertyValue(propertyValue);
            }
            if (getRegistry().containsBeanDefinition(beanName)){
                throw new BeansException("Duplicate beanName[" + beanName + "] is not allowed");
            }
            getRegistry().registryBeanDefinition(beanName,beanDefinition);
        }
    }

}
