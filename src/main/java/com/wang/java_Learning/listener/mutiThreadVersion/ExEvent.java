package com.wang.java_Learning.listener.mutiThreadVersion;

import java.util.EventObject;

public class ExEvent extends EventObject {
    private ExSource source;
    private int state;
    private String msg;

    public ExEvent(ExSource source){
        super(source);
        state = source.getState();
        msg = source.getMsg();
    }

    public int getState(){
        return state;
    }

    public String getMsg(){
        return msg;
    }

}
