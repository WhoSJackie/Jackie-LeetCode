package com.wang.javaL.concurrentLearn;


public class Singleton {


    //懒汉式
    //volatile避免指令重排
//    private static volatile Singleton instance=null;
//
//    private Singleton(){}
//
//    public Singleton getInstance(){
//        if(instance==null){
//            synchronized(Singleton.class){
//                if(instance==null){
//                    instance=new Singleton();
//                }
//            }
//        }
//        return instance;
//    }

    //饿汉式,外部类无法访问静态内部类
    static class LazyHolder{
        private static Singleton instance=new Singleton();
    }

    private Singleton(){};

    public static Singleton getInstance(){
        return LazyHolder.instance;
    }



}
