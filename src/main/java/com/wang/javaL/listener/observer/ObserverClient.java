package com.wang.javaL.listener.observer;

public class ObserverClient {

    public static void main(String[] args) {
        EventPublisher publisher = new EventPublisher();
        publisher.registry.subscribe("change",new EventSubscriber());
        publisher.change();
    }

}
