package com.wang.java_Learning.generic.genericInterface;

public class TigerImpl implements TigerGarden<String,Integer>{

    @Override
    public void test01(String name) {
        System.out.println(name);
    }

    @Override
    public void test02(Integer integer) {
        System.out.println(integer);
    }

    public static void main(String[] args) {
        TigerImpl tiger=new TigerImpl();
        tiger.test01("Jackie");
        tiger.test02(2);
    }
}
