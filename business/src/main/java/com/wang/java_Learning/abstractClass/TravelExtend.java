package com.wang.java_Learning.abstractClass;

public class TravelExtend extends TravelAbstract{
    @Override
    public void printAbstractMsg() {
        System.out.println("抽象类中的抽象方法");
    }
    public static void main(String[] args) {
        TravelExtend travelExtend=new TravelExtend();
        travelExtend.printMsg();
        travelExtend.printAbstractMsg();
    }
}
