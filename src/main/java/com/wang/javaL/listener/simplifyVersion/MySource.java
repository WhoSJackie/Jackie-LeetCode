package com.wang.javaL.listener.simplifyVersion;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

public class MySource {


    private int state = 0;

    private String msg = "";

    Set<EventListener> set = new HashSet<>();

    public MySource(EventListener listener){
        set.add(listener);
    }

    public void notifyListener(){
        for (EventListener listener : set) {
            ((MyEventListener)listener).handleEvent(new MyEvent(this));
        }
    }

    public void changeState(){
        state = state==0?1:0;
        msg = "state change!";
        notifyListener();
    }

    public int getState(){
        return state;
    }

    public String getMsg(){
        return msg;
    }


}
