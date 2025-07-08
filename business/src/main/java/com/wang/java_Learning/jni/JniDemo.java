package com.wang.java_Learning.jni;

public class JniDemo {

    {
        System.loadLibrary("JNIDemo");
    }

    public native void sayHello();

}
