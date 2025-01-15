package com.wang.java_Learning.designPattern.factory;

public class FactoryProducer {

    public static  AbstractFactory getFactory(String factoryName){
        if (factoryName.equalsIgnoreCase("Lang")){
            return new LangFactory();
        }
        return null;
    }

}
