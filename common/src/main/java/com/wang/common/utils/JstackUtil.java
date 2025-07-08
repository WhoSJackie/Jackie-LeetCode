package com.wang.common.utils;

import java.util.Map;

public class JstackUtil {

    public static void getStackInfo(){
        Map<Thread, StackTraceElement[]> threadMap = Thread.getAllStackTraces();
        for (Thread thread : threadMap.keySet()) {
            StackTraceElement[] elements = threadMap.get(thread);
            if (thread.equals(Thread.currentThread())) continue;
            System.out.println("线程名：{"+thread.getName()+"}的线程堆栈信息如下:");
            for (StackTraceElement element : elements) {
                System.out.println("\t"+element+"\n");
            }
        }
    }

    public static void main(String[] args) {
        getStackInfo();
    }

}
