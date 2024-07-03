package com.wang.javaL.listener.observer;

public class EventPublisher {

    public EventRegistry registry;

    public EventPublisher(){
        registry = new EventRegistry("change");
    }

    public void change(){
        registry.notify("change");
    }


}
