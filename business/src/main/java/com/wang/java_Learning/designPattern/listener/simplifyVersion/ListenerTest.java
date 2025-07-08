package com.wang.java_Learning.designPattern.listener.simplifyVersion;

public class ListenerTest {

    public static void main(String[] args) {
        MyEventListener listener = new MyEventListener();
        MySource source = new MySource(listener);
        source.changeState();
    }

}
