package com.wang.javaL.threadLocal;

public class EnumStaticTest {

    public void test1(EnumAndStatic es){
        switch(es){
            case spring:
                break;
            case summer:
                break;
            case autumn:
                break;
            case winter:
                break;
            default:
                break;
        }
    }

    public void test2(int es){
        switch(es){
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                break;
        }
    }

    public static void main(String[] args) {
        EnumStaticTest e =new EnumStaticTest();
        long t=System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            e.test1(EnumAndStatic.spring);
        }
        System.out.println("enum costs time is:"+(System.currentTimeMillis()-t));

        long tt=System.currentTimeMillis();
        for(int i=0;i<1000000;i++){
            e.test2(StaticAndEnum.spring);
        }
        System.out.println("static costs time is:"+(System.currentTimeMillis()-tt));

    }
}
