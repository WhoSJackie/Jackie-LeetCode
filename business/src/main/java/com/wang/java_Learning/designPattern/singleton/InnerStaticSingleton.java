package com.wang.java_Learning.designPattern.singleton;

public class InnerStaticSingleton {

    private InnerStaticSingleton(){

    }

    public InnerStaticSingleton getInstance(){
        return InnerSingleton.Instance;
    }


    static class InnerSingleton{
        private static final InnerStaticSingleton Instance = new InnerStaticSingleton();
    }


}
