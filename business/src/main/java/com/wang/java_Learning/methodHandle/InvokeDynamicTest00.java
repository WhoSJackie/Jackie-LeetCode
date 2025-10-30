package com.wang.java_Learning.methodHandle;

import java.lang.invoke.CallSite;
import java.lang.invoke.ConstantCallSite;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class InvokeDynamicTest00 {

    public static void main(String[] args) {

    }

    public static void testMethod(String s){
        System.out.println("hello,String:"+s);
    }

    public static CallSite BootstrapMethod(MethodHandles.Lookup lookup, String name, MethodType mt) throws Throwable {
        return new ConstantCallSite(lookup.findStatic(InvokeDynamicTest00.class,name ,mt));
    }



}
