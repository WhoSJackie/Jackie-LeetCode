package com.wang.java_Learning.jvm_learning;

public class Dispatch {

    static class Father{
        public int a = 1;
        public Father(){
            a=2;
            func();
        }
        public void func(){
            System.out.println("This is father,i have $"+ a );
        }
    }

    static class Child extends Father{
        public int a = 3;
        public Child(){
            a=4;
            func();
        }
        public void func(){
            System.out.println("This is child,i have $"+ a );
        }
    }

    public static void main(String[] args) {
        Father f = new Child();
        System.out.println("I have $"+f.a);
    }


}
