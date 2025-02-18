package com.wang.java_Learning.designPattern.listener.simplifyVersion;

import java.util.EventObject;

public class MyEvent extends EventObject {

    private int state;

    private String msg;

    public MyEvent(MySource source){
        super(source);
        this.state = source.getState();
        this.msg = source.getMsg();
    }

    public int getState() {
        return state;
    }

    public String getMsg() {
        return msg;
    }
}
