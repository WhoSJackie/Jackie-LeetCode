package com.wang.java_Learning.designPattern.listener.observer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventRegistry {

    Map<String, List<EventSubscriber>> registry = new HashMap<>();

    public  EventRegistry(String eventType){
        registry.put(eventType,new ArrayList<>());
    }

    public void subscribe(String eventType,EventSubscriber subscriber){
        List<EventSubscriber> eventSubscribers = registry.get(eventType);
        eventSubscribers.add(subscriber);
    }

    public void notify(String eventType){
        List<EventSubscriber> users = registry.get(eventType);
        for (EventSubscriber user : users) {
            user.handle(eventType);
        }
    }



}
