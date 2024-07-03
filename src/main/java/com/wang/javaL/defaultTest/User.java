package com.wang.javaL.defaultTest;

public class User extends PersonB implements PersonA{

    public static void main(String[] args) {
//        User user=new User();
//        user.a();

        try {
            System.out.println(Class.forName("com.wang.javaL.defaultTest.User"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
