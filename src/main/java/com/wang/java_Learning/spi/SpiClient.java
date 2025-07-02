package com.wang.java_Learning.spi;

import java.util.ServiceLoader;

public class SpiClient {

    public static void main(String[] args) {
        ServiceLoader<SpiService> loader = ServiceLoader.load(SpiService.class);
        for (SpiService service : loader) {
            service.helloWorld();
        }
    }
}
