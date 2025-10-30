package com.wang.java_Learning.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodType;

import static java.lang.invoke.MethodHandles.lookup;

public class MethodHandleTest {

    public static void main(String[] args) throws Throwable {
        Object reveiver = System.currentTimeMillis()%2==0?System.out:new ClassA();
        getPrintlnMH(reveiver).invoke("jackie");
    }

    private static MethodHandle getPrintlnMH(Object reveiver) throws Throwable {
        MethodType mt = MethodType.methodType(void.class,String.class);
        // 使用bindTo来完成Java方法中第一个隐形参数所代表的接受者
        return lookup().findVirtual(reveiver.getClass(),"println",mt).bindTo(reveiver);
    }

}

class ClassA{
    public void println(String str){
        System.out.println(str);
    }
}
