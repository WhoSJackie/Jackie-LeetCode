package com.wang.java_Learning.designPattern.listener.observer;

public class EventSubscriber {

    public void handle(String eventType){
        System.out.println("eventType is: "+eventType);
    }

}
