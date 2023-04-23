package com.wang.java_Learning.InnerClass;

public class InnerClassTest01 {

    private String name;

    public InnerClassTest01(String name){
        this.name = name;
    }

    public class InnerClass{
        public void getName(){
            System.out.println(name);
        }

    }


    public static void main(String[] args) {
        InnerClassTest01 test = new InnerClassTest01("Jackie");
        InnerClassTest01.InnerClass inner= test.new InnerClass();
        inner.getName();
    }

}
