package com.wang.java_Learning.listener.mutiThreadVersion;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExSource {
    private int state=0;
    private String msg="";
    Set<Class<?>> listenerList = new HashSet<>();

    public void subscribeListener(Class<?> listener){
        listenerList.add(listener);
    }

    public void notifyListener() throws Exception {
        ExecutorService threadPool = Executors.newCachedThreadPool();
        List<Future<String>> futureList = new ArrayList<>();
        for (Class<?> listener : listenerList) {
            Constructor<?> ct = listener.getConstructor(ExEvent.class);
            Object obj = new ExEvent(this);
            ComEventListener target = (ComEventListener)ct.newInstance(obj);
            futureList.add(threadPool.submit(target));
        }

        // 获取结果
        for (Future<String> res : futureList) {
            try{
                while(!res.isDone());
                System.out.println("result is :"+res.get());
            } catch (Exception e){
                e.printStackTrace();
            } finally{
                threadPool.shutdown();
            }
        }
    }

    public void changeState() throws Exception {
        state = state==1?0:1;
        System.out.println("State change!");
        msg = "send msg!";
        notifyListener();
        System.out.println("Finished!");
    }

    public int getState(){
        return state;
    }

    public String getMsg(){
        return msg;
    }

}
