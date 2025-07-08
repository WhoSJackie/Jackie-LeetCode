package com.wang.java_Learning.jvm_learning;

public class StaticDispatch {

    static abstract class Human{}

    static class Man extends Human{}

    static class Woman extends Human{}

    static void sayHello(Human human){
        System.out.println("Human say hello!");
    }

    static void sayHello(Man human){
        System.out.println("Man say hello!");
    }

    static void sayHello(Woman human){
        System.out.println("Woman say hello!");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        sayHello(man);
        sayHello(woman);
    }


}
