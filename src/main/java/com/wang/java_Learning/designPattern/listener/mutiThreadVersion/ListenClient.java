package com.wang.java_Learning.designPattern.listener.mutiThreadVersion;

public class ListenClient {

    public static void main(String[] args) {
        ExSource source = new ExSource();
        try {
            source.subscribeListener(Class.forName("com.wang.java_Learning.designPattern.listener.mutiThreadVersion.ExEventListener"));
            source.changeState();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
