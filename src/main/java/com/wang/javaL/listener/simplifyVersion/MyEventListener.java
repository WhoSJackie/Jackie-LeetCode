package com.wang.javaL.listener.simplifyVersion;

import java.util.EventListener;

public class MyEventListener implements EventListener {

    public void handleEvent(MyEvent event){
        System.out.println(event.toString()+"-->"+event.getMsg());
    }


}
