package com.wang.java_Learning.designPattern.listener.mutiThreadVersion;

public class ExEventListener implements ComEventListener{
    private ExEvent event;

    public ExEventListener(ExEvent event){
        this.event = event;
    }

    @Override
    public String call() throws Exception {
        System.out.println("Receive message!");
        System.out.println("Event Msg is: "+event.getMsg()+"| Event State is:"+event.getState());
        return "SUCCESS";
    }
}
