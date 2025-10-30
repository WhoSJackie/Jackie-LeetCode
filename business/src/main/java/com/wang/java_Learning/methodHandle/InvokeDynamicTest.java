package com.wang.java_Learning.methodHandle;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Field;

public class InvokeDynamicTest {

    public static void main(String[] args) {
        new Son().thinking();
    }

}

class GrandFather{
    void thinking(){
        System.out.println("This is grandFather!");
    }
}

class Father extends GrandFather{
    void thinking(){
        System.out.println("This is father!");
    }
}

class Son extends Father{
    void thinking(){
        try{
            MethodType mt = MethodType.methodType(void.class);
            Field lookupImpl = MethodHandles.Lookup.class.getDeclaredField("IMPL_LOOKUP");
            lookupImpl.setAccessible(true);
            MethodHandle mh = ((MethodHandles.Lookup) lookupImpl.get(null)).findSpecial(GrandFather.class, "thinking", mt, GrandFather.class);
            mh.invoke(this);
        } catch (Throwable e){
            e.printStackTrace();
        }

    }

}
