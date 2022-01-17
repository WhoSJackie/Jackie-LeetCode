package com.wang.java_Learning;

public class TestSingleton {

    public CompactCD getCompactCD1(){
        return CompactCD.getInstance();
    }

    public CompactCD getCompactCD2(){
        return CompactCD.getInstance();
    }


    public static void main(String[] args) {
        TestSingleton testSingleton=new TestSingleton();
        System.out.println(testSingleton.getCompactCD1().equals(testSingleton.getCompactCD2()));
    }

}
