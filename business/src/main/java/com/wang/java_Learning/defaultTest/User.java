package com.wang.java_Learning.defaultTest;

public class User extends PersonB implements PersonA{

    public static void main(String[] args) {
//        User user=new User();
//        user.a();

        try {
            System.out.println(Class.forName("com.wang.java_Learning.defaultTest.User"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
