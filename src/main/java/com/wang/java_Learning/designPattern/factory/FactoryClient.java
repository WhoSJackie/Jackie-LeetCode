package com.wang.java_Learning.designPattern.factory;

public class FactoryClient {

    public static void main(String[] args) {
        AbstractFactory factory = FactoryProducer.getFactory("Lang");
        Lang c = factory.productLang("C");
        System.out.println(c.produceName());
    }

}
