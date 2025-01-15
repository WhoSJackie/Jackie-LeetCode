package com.wang.java_Learning.exception;

public class TestInstanceOf {

    public void exceptionTest(){
        try{
            int i=1/0;
        }catch(Exception e){
            if(e instanceof RuntimeException ){
                System.out.println("运行时错误："+e);
            }
        }
    }

    public int testTryCatch(int index,int count){
        count=0;
        if (index==2){
            index=index/0;
        }
        System.out.println(index);
        count++;
        return count;
    }

    public static void main(String[] args) {
        TestInstanceOf testInstanceOf=new TestInstanceOf();
//        System.out.println(testInstanceOf instanceof TestInstanceOf);
//        testInstanceOf.exceptionTest();

//        System.out.println(testInstanceOf instanceof List);


    }


}
