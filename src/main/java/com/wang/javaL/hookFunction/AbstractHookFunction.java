package com.wang.javaL.hookFunction;

public abstract class AbstractHookFunction implements HookFunction{

    public abstract void testPrintln();

    @Override
    public void testPrintf() {
        System.out.printf("[%d]号选手上场",1);
    }
}
