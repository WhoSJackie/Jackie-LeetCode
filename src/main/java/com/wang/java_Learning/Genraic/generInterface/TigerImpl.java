package com.wang.java_Learning.Genraic.generInterface;

public class TigerImpl implements TigerGarden<String,Integer>{
    @Override
    public void Test01(String name) {
        System.out.println(name);
    }

    @Override
    public void test02(Integer s) {
        System.out.println("No."+s);
    }

    public static void main(String[] args) {
        TigerImpl tiger=new TigerImpl();
        tiger.Test01("jackie");
        tiger.test02(2);
    }
}
