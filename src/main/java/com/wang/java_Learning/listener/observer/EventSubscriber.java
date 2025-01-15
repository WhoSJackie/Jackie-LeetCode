package com.wang.java_Learning.listener.observer;

public class EventSubscriber {

    public void handle(String eventType){
        System.out.println("eventType is: "+eventType);
    }

}
