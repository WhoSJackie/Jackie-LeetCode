package com.wang.java_Learning.enums;

public enum PizzaDeliveryStrategy {

    EXPRESS{
        @Override
        public void deliver(PizzaEnum set) {
            System.out.println("express");
        }
    },

    NORMAL{
        @Override
        public void deliver(PizzaEnum set) {
            System.out.println("normal");
        }
    };

    public abstract void deliver(PizzaEnum set);


}
