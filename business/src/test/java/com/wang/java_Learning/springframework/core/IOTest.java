package com.wang.java_Learning.springframework.core;

import cn.hutool.core.io.IoUtil;
import com.wang.java_Learning.springframework.core.io.DefaultResourceLoader;
import com.wang.java_Learning.springframework.core.io.Resource;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class IOTest {

    private DefaultResourceLoader resourceLoader;
    @Before
    public void init() {
        resourceLoader = new DefaultResourceLoader();
    }

    @Test
    public void test() throws IOException {
        Resource resource = resourceLoader.getResource("classpath:import.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }

    @Test
    public void test1() throws IOException {
        Resource resource = resourceLoader.getResource("src/main/resources/import.properties");
        InputStream inputStream = resource.getInputStream();
        String s = IoUtil.readUtf8(inputStream);
        System.out.println(s);
    }


}
