package com.wang.learning;

public class Student extends User{
    static{
        System.out.println("子类静态代码块");
    }

    {
        System.out.println("子类代码块");
    }

    Student(){
        System.out.println("子类构造方法");
    }

    public static void main(String[] args) {
        System.out.println("子类main方法");
        Student student=new Student();
    }

}
