package com.wang.java_Learning.designPattern.factory;

public class LangFactory extends AbstractFactory{
    @Override
    public Lang productLang(String name) {
        switch(name){
            case "C" : return new C();
            case "J" : return new J();
            default: return new J();
        }
    }
}
