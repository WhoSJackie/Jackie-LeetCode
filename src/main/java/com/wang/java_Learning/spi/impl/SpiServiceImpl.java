package com.wang.java_Learning.spi.impl;

import com.wang.java_Learning.spi.SpiService;

public class SpiServiceImpl implements SpiService {
    @Override
    public void helloWorld() {
        System.out.println("hello world!");
    }
}
