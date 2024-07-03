package com.wang.javaL.listener.mutiThreadVersion;

public class ListenClient {

    public static void main(String[] args) {
        ExSource source = new ExSource();
        try {
            source.subscribeListener(Class.forName("com.wang.javaL.listener.mutiThreadVersion.ExEventListener"));
            source.changeState();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
